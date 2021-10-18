package ru.thechsrv.jsonapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ru.thechsrv.jsonapp.databinding.FragmentProjectsDtlBinding
import ru.thechsrv.jsonapp.model.ProjectDtl
import ru.thechsrv.jsonapp.model.Projects
import java.text.DateFormat.getDateInstance
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class ProjectsDtlFragment : Fragment() {

    private lateinit var projectsDtlViewModel: ProjectsDtlViewModel
    private var _binding: FragmentProjectsDtlBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        projectsDtlViewModel =
            ViewModelProvider(this).get(ProjectsDtlViewModel::class.java)

        _binding = FragmentProjectsDtlBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNotifications



        val project = arguments?.getParcelable<ProjectDtl>("keyJ")!!
        Log.d("ZZZproject", project.toString())

        projectsDtlViewModel.text.observe(viewLifecycleOwner, Observer {
            try {
                val parsedDate = LocalDate.parse(project.startDate,
                    DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"))
                println("ZZZprojectDecember 21, 2018 : "+parsedDate)
                textView.text = parsedDate.format(DateTimeFormatter.ofPattern("d.MMMM.yyyy"))
            } catch (E: Exception) {
                textView.text = project.startDate

            }

        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}