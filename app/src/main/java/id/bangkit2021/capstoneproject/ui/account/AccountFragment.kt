package id.bangkit2021.capstoneproject.ui.account

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import id.bangkit2021.capstoneproject.databinding.FragmentAccountBinding
import id.bangkit2021.capstoneproject.ui.loginregister.LoginRegisterActivity


class AccountFragment : Fragment() {

    private var _binding : FragmentAccountBinding? = null
    private val binding get() = _binding!!
    private lateinit var mAuth : FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAccountBinding.inflate(inflater, container, false)

        mAuth = FirebaseAuth.getInstance()
        val currentUser = mAuth.currentUser
        binding.accountName.text = currentUser?.displayName
        binding.accountEmail.text = currentUser?.email
        Glide.with(requireActivity())
            .load(currentUser?.photoUrl)
            .into(binding.imageAccount)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogout.setOnClickListener {
            mAuth.signOut()
            val intent = Intent(context, LoginRegisterActivity::class.java)
            startActivity(intent)
        }
    }
}