package id.bangkit2021.capstoneproject.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import id.bangkit2021.capstoneproject.databinding.FragmentRiskBinding

class RiskFragment : Fragment() {
    //Variable Binding
    private var _binding: FragmentRiskBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //set Binding
        _binding = FragmentRiskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Call AboutViewModel
        val aboutViewModel = ViewModelProvider(
            requireActivity(),
            ViewModelProvider.NewInstanceFactory()
        )[AboutViewModel::class.java]
        val aboutTumor = aboutViewModel.getAboutData()

        //set title and content for index no 3 : Risk
        binding.tvTitle.text = aboutTumor[3].title
        binding.tvContent.text = aboutTumor[3].content
    }
}