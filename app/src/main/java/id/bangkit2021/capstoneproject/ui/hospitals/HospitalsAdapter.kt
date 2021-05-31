package id.bangkit2021.capstoneproject.ui.hospitals

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import id.bangkit2021.capstoneproject.data.HospitalsObject
import id.bangkit2021.capstoneproject.databinding.HospitalCardListBinding

class HospitalsAdapter : RecyclerView.Adapter<HospitalsAdapter.ViewHolder>() {
    private val listHospitals = ArrayList<HospitalsObject>()

    fun setHospitals(hospitals: List<HospitalsObject>){
        this.listHospitals.clear()
        this.listHospitals.addAll(hospitals)
    }
    class ViewHolder(private val binding: HospitalCardListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindHospitals(hospitals: HospitalsObject){
            with(binding){
                textNameHospitals.text = hospitals.hospitalsName
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, HospitalDetailActivity::class.java)
                    intent.putExtra(HospitalDetailActivity.HOSPITALS, hospitals)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(hospitals.hospitalsPhotoUrl)
                    .transform(RoundedCorners(20))
                    .into(photoHospitals)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = HospitalCardListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hospital = listHospitals[position]
        holder.bindHospitals(hospital)
    }

    override fun getItemCount(): Int = listHospitals.size

}