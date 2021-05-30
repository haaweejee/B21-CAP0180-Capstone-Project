package id.bangkit2021.capstoneproject.ui.about

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import id.bangkit2021.capstoneproject.R
import id.bangkit2021.capstoneproject.databinding.FragmentRiskBinding

class RiskFragment : Fragment() {
    private var _binding : FragmentRiskBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentRiskBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val aboutViewModel = ViewModelProvider(requireActivity(),
            ViewModelProvider.NewInstanceFactory())[AboutViewModel::class.java]
        val aboutTumor = aboutViewModel.getAboutData()

        binding.tvTitle.text = aboutTumor[3].title
        binding.tvContent.text = aboutTumor[3].content
    }
}