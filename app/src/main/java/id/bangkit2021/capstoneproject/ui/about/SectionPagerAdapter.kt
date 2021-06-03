@file:Suppress("DEPRECATION")

package id.bangkit2021.capstoneproject.ui.about

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import id.bangkit2021.capstoneproject.R

@Suppress("DEPRECATION")
class SectionPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    //Set Tab Titles for About Activity
    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.about,
            R.string.indication,
            R.string.treatment,
            R.string.risk
        )
    }

    //For Tab titles size
    override fun getCount(): Int = TAB_TITLES.size

    //For call Fragment with the Index
    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> TumorFragment()
            1 -> IndicationFragment()
            2 -> TreatmentFragment()
            3 -> RiskFragment()
            else -> Fragment()
        }

    //Get Tabs Title
    override fun getPageTitle(position: Int): CharSequence =
        context.resources.getString(TAB_TITLES[position])

}