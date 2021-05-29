package id.bangkit2021.capstoneproject.ui.onboarding.screen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import id.bangkit2021.capstoneproject.MainActivity
import id.bangkit2021.capstoneproject.R
import id.bangkit2021.capstoneproject.databinding.FragmentFirstScreenBinding
import id.bangkit2021.capstoneproject.databinding.FragmentSecondScreenBinding


class SecondScreenFragment : Fragment() {

    private var _binding : FragmentSecondScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondScreenBinding.inflate(inflater, container, false)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager2)
        binding.btnNext.setOnClickListener {
            viewPager?.currentItem = 2
        }

        binding.btnSkip.setOnClickListener {
            val moveToHome = Intent(context, MainActivity::class.java)
            startActivity(moveToHome)
            onBoardingFinished()
            activity?.finish()
        }

        return binding.root
    }

    private fun onBoardingFinished(){
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }

}