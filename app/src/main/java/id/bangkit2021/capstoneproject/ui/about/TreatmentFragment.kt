package id.bangkit2021.capstoneproject.ui.about

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import id.bangkit2021.capstoneproject.R
import id.bangkit2021.capstoneproject.databinding.FragmentTreatmentBinding

class TreatmentFragment : Fragment() {

    private var _binding : FragmentTreatmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTreatmentBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val aboutViewModel = ViewModelProvider(requireActivity(),
            ViewModelProvider.NewInstanceFactory())[AboutViewModel::class.java]
        val aboutTumor = aboutViewModel.getAboutData()

        binding.tvTitle.text = aboutTumor[2].title
        binding.tvContent.text = aboutTumor[2].content
    }




}