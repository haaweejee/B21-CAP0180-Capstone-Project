package id.bangkit2021.capstoneproject.ui.onboarding.screen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import id.bangkit2021.capstoneproject.databinding.FragmentThirdScreenBinding
import id.bangkit2021.capstoneproject.ui.loginregister.LoginRegisterActivity


class ThirdScreenFragment : Fragment() {

    private var _binding: FragmentThirdScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdScreenBinding.inflate(inflater, container, false)

        binding.btnFinish.setOnClickListener {
            val intent = Intent(context, LoginRegisterActivity::class.java)
            startActivity(intent)
            onBoardingFinished()
            activity?.finish()
        }

        return binding.root
    }

    private fun onBoardingFinished() {
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }


}