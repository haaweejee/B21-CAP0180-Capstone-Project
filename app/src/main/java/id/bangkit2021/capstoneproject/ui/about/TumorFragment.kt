package id.bangkit2021.capstoneproject.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import id.bangkit2021.capstoneproject.databinding.FragmentTumorBinding


class TumorFragment : Fragment() {
    private var _binding : FragmentTumorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTumorBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val aboutViewModel = ViewModelProvider(requireActivity(),
            ViewModelProvider.NewInstanceFactory())[AboutViewModel::class.java]
        val aboutTumor = aboutViewModel.getAboutData()
        binding.tvTitle.text = aboutTumor[0].title
        binding.tvContent.text = aboutTumor[0].content
        Glide.with(this)
            .load("https://res.cloudinary.com/dk0z4ums3/image/upload/v1589974396/attached_image/tumor-otak-0-alodokter.jpg")
            .into(binding.imgView)
    }
}