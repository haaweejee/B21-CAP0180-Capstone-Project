@file:Suppress("DEPRECATION")

package id.bangkit2021.capstoneproject.ui.loginregister

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import id.bangkit2021.capstoneproject.R


class LoginRegisterViewPager(private val context: Context, fm: FragmentManager ) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    companion object{
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.login,
            R.string.register
        )
    }

    override fun getCount(): Int = TAB_TITLES.size

    override fun getItem(position: Int): Fragment =
        when(position){
            0 -> LoginFragment()
            1 -> RegisterFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence = context.getString(TAB_TITLES[position])

}