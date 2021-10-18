package ru.thechsrv.jsonapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.thechsrv.jsonapp.databinding.FragmentProjectsBinding
import ru.thechsrv.jsonapp.databinding.FragmentListCatsItemBinding
import ru.thechsrv.jsonapp.model.ProjectDtl
import ru.thechsrv.jsonapp.model.Projects

class ProjectsFragment : Fragment() {

    private lateinit var projectsViewModel: ProjectsViewModel
    private var _binding: FragmentProjectsBinding? = null
    private lateinit var photoRecyclerView: RecyclerView

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        projectsViewModel.text.observe(viewLifecycleOwner, { projects ->
            photoRecyclerView.adapter = PhotoAdapter(projects)
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        projectsViewModel =
            ViewModelProvider(this).get(ProjectsViewModel::class.java)

        _binding = FragmentProjectsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val projects = arguments?.getParcelable<Projects>("keyJ")
        Log.d("ZZZ", projects.toString())

        photoRecyclerView = binding.photoRecyclerView
        if (projects != null) {
            if (projectsViewModel.projectssss  == null) {
                projectsViewModel.setProjects(projects)
            }
        } else {
            projectsViewModel.text.value?.let {
                projectsViewModel.setProjects(it)
            }
        }
        //
        val layoutManager = LinearLayoutManager(context)
//        layoutManager.reverseLayout = true
//        layoutManager.stackFromEnd = true
        photoRecyclerView.layoutManager = layoutManager


//        val textView: TextView = binding.textDashboard
//        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    class PhotoHolder(private val _binding: FragmentListCatsItemBinding) : RecyclerView.ViewHolder(_binding.getRoot()),
        View.OnClickListener {
        private var _projectDtl: ProjectDtl? = null

        fun bindView(projectDtl: ProjectDtl) {
            _binding.textSubject.text = projectDtl.subject
            _projectDtl = projectDtl
        }

        init {
            _binding.root.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            Log.d("ZZZ", _projectDtl.toString())
            val bundle  = Bundle()
            bundle.putParcelable("keyJ", _projectDtl)
            _binding.root.findNavController().navigate(R.id.navigation_notifications, bundle)
        }

    }

    inner class PhotoAdapter(private val projects: Projects?) : RecyclerView.Adapter<PhotoHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {
//            TestListItemBinding.inflate(getLayoutInflater())
//            val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_list_cats_item, parent, false)
            return PhotoHolder(FragmentListCatsItemBinding.inflate(layoutInflater))
        }

        override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
            holder.bindView(projects!!.projectList[position])
        }

        override fun getItemCount(): Int {
           return projects!!.projectList.size
        }

    }
}