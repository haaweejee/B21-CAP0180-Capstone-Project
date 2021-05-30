package id.bangkit2021.capstoneproject.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.bangkit2021.capstoneproject.R
import id.bangkit2021.capstoneproject.databinding.FragmentAccountBinding
import id.bangkit2021.capstoneproject.ui.loginregister.LoginRegisterActivity


class AccountFragment : Fragment() {

    private var _binding : FragmentAccountBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAccountBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogout.setOnClickListener {
            val intent = Intent(context, LoginRegisterActivity::class.java)
            startActivity(intent)
        }
    }
}