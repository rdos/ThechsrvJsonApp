package ru.thechsrv.jsonapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.google.gson.Gson
import org.json.JSONArray
import ru.thechsrv.jsonapp.databinding.FragmentDataBinding
import org.json.JSONObject
import ru.thechsrv.jsonapp.model.Projects
import ru.thechsrv.jsonapp.model.Users


class DataFragment : Fragment() {

    private lateinit var dataViewModel: DataViewModel
    private var _binding: FragmentDataBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataViewModel =
            ViewModelProvider(this).get(DataViewModel::class.java)

        _binding = FragmentDataBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val labelTextView = binding.textJsonLabelData
        dataViewModel.text.observe(viewLifecycleOwner, Observer {
            labelTextView.text = it
        })

        val jsonData: TextInputEditText =  binding.textJsonData

        root.findViewById<Button>(R.id.button).setOnClickListener{
//            val jObject = JSONObject(jsonData.text.toString())
            val jsonString = jsonData.text.toString()

            Log.e("ZZZ", jsonString)
            val projects = Gson().fromJson(jsonString, Projects::class.java)

            Log.d("ZZZ", projects.toString())
            val bundle  = Bundle()
            bundle.putParcelable("keyJ", projects)
            it.findNavController().navigate(R.id.navigation_dashboard, bundle)
        }
//        (
//                Navigation.createNavigateOnClickListener(R.id.navigation_blank,
//                    null))
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}