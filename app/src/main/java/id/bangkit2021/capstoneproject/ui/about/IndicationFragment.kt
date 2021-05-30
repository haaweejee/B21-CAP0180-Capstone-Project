package id.bangkit2021.capstoneproject.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import id.bangkit2021.capstoneproject.databinding.FragmentIndicationBinding


class IndicationFragment : Fragment() {
    private var _binding : FragmentIndicationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentIndicationBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val aboutViewModel = ViewModelProvider(requireActivity(),
            ViewModelProvider.NewInstanceFactory())[AboutViewModel::class.java]
        val aboutTumor = aboutViewModel.getAboutData()

        binding.tvTitle.text = aboutTumor[1].title
        binding.tvContent.text = aboutTumor[1].content
    }
}