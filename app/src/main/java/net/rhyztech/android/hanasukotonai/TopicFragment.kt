package net.rhyztech.android.hanasukotonai

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class TopicFragment : Fragment() {

    private val topicViewModel: TopicViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_topic, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val packageName = activity!!.packageName

        val topicText = view.findViewById<TextView>(R.id.topicText)
        topicViewModel.topic.observe(this, { topic ->
            val stringId = resources.getIdentifier(topic.titleId, "string", packageName)
            topicText.text = getString(stringId)
        })

        view.findViewById<Button>(R.id.changeTopicButton).setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch {
                topicViewModel.changeTopic()
            }
        }
    }
}