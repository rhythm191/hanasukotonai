package net.rhyztech.android.hanasukotonai

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.viewModels


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

        val topicText = view.findViewById<TextView>(R.id.topicText)
        val packageName = activity!!.packageName

        topicViewModel.topicText.observe(this, { value ->
            val stringId = resources.getIdentifier(value, "string", packageName)
            topicText.text = getString(stringId)
        })

        view.findViewById<Button>(R.id.changeTopicButton).setOnClickListener {
            topicViewModel.changeTopic()
        }
    }
}