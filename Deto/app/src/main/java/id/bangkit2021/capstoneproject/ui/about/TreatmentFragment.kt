package id.bangkit2021.capstoneproject.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import id.bangkit2021.capstoneproject.databinding.FragmentTreatmentBinding

class TreatmentFragment : Fragment() {

    //Variable Binding
    private var _binding: FragmentTreatmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //Set Binding
        _binding = FragmentTreatmentBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
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

        //set Title and content for index 2 : Treatment
        binding.tvTitle.text = aboutTumor[2].title
        binding.tvContent.text = aboutTumor[2].content
    }


}