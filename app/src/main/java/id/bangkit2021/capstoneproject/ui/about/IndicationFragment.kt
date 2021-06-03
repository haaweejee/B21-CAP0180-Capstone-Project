package id.bangkit2021.capstoneproject.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import id.bangkit2021.capstoneproject.databinding.FragmentIndicationBinding


class IndicationFragment : Fragment() {
    //Variable
    private var _binding: FragmentIndicationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //set Binding
        _binding = FragmentIndicationBinding.inflate(inflater, container, false)
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

        //set Title and content index no 1 : Indication
        binding.tvTitle.text = aboutTumor[1].title
        binding.tvContent.text = aboutTumor[1].content
    }
}