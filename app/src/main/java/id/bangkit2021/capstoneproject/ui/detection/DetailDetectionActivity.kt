package id.bangkit2021.capstoneproject.ui.detection

import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.bangkit2021.capstoneproject.ui.MainActivity
import id.bangkit2021.capstoneproject.R
import id.bangkit2021.capstoneproject.data.TumorDummy
import id.bangkit2021.capstoneproject.databinding.ActivityDetailDetectionBinding
import id.bangkit2021.capstoneproject.ui.preference.PreferenceActivity

@Suppress("DEPRECATION")
class DetailDetectionActivity : AppCompatActivity() {

    companion object {
        const val RESULT_IMAGE = "bitmapImage"
        const val RESULT_TEXT = "typeTumor"
    }

    private lateinit var binding: ActivityDetailDetectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailDetectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getResult()

        supportActionBar?.title = getString(R.string.checking_result)
        val byteArray = intent.getByteArrayExtra(RESULT_IMAGE)

        binding.btnHome.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.btnPreference.setOnClickListener {
            intent = Intent(this, PreferenceActivity::class.java)
            intent.putExtra(PreferenceActivity.RESULT_IMAGE, byteArray)
            startActivity(intent)

        }
    }

    private fun getResult() {
        val byteArray = intent.getByteArrayExtra(RESULT_IMAGE)
        val bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray!!.size)

        val typeTumor = intent.getStringExtra(RESULT_TEXT)
        val tumorData = TumorDummy.getTumorData()

        binding.imageView.setImageDrawable(BitmapDrawable(applicationContext.resources, bmp))
        when (typeTumor) {
            "no_tumor" -> {
                binding.tvTypeTumor.text =
                    String.format(getString(R.string.tumor_type), tumorData[0].typeTumor)
                binding.tvDescTumor.text =
                    String.format(getString(R.string.tumor_desc), tumorData[0].descTumor)
            }
            "glioma_tumor" -> {
                binding.tvTypeTumor.text =
                    String.format(getString(R.string.tumor_type), tumorData[1].typeTumor)
                binding.tvDescTumor.text =
                    String.format(getString(R.string.tumor_desc), tumorData[1].descTumor)
            }
            "meningioma_tumor" -> {
                binding.tvTypeTumor.text =
                    String.format(getString(R.string.tumor_type), tumorData[2].typeTumor)
                binding.tvDescTumor.text =
                    String.format(getString(R.string.tumor_desc), tumorData[2].descTumor)
            }
            "pituitary_tumor" -> {
                binding.tvTypeTumor.text =
                    String.format(getString(R.string.tumor_type), tumorData[3].typeTumor)
                binding.tvDescTumor.text =
                    String.format(getString(R.string.tumor_desc), tumorData[3].descTumor)
            }
        }
    }
}