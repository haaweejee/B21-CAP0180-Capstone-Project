package id.bangkit2021.capstoneproject.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import id.bangkit2021.capstoneproject.databinding.FragmentViewPagerBinding
import id.bangkit2021.capstoneproject.ui.onboarding.screen.FirstScreenFragment
import id.bangkit2021.capstoneproject.ui.onboarding.screen.SecondScreenFragment
import id.bangkit2021.capstoneproject.ui.onboarding.screen.ThirdScreenFragment


class ViewPagerFragment : Fragment() {

    private var _binding: FragmentViewPagerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding = FragmentViewPagerBinding.inflate(inflater, container, false)

        val fragmentList = arrayListOf(
            FirstScreenFragment(),
            SecondScreenFragment(),
            ThirdScreenFragment()
        )


        val mAdapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        binding.viewPager2.adapter = mAdapter

        return binding.root
    }


}