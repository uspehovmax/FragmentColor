package ru.uspehovmax.fragmentcolor

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import ru.uspehovmax.fragmentcolor.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    // для обращения через binding
    private var _binding: FragmentSecondBinding? = null
    val binding: FragmentSecondBinding
        get() = _binding ?: throw RuntimeException("FragmentSecondBinding == null")

    private lateinit var nameColor: String
    private lateinit var color: Color
    private var numberColor: Int = 0


    companion object {
        const val NAME = "SecondFragment"
        private const val KEY_COLOR = "color"
        fun newInstance(color: Color): SecondFragment {
            return SecondFragment().apply {
                arguments = Bundle().apply {
                    // сериализация - перевод объекта в байты для передачи
                    putParcelable(KEY_COLOR, color)
                    Log.d(
                        "msg",
                        "newInstance color.name: ${color.name}, color.number ${color.number}"
                    )
                }
            }
        }
    }

    private fun parseArgs() {
        requireArguments().getParcelable<Color>(KEY_COLOR)?.let {
            color = it
            Log.d("msg", "parseArgs color.name: ${color.name}, color.number ${color.number}")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = arguments
        if (args == null) {
            nameColor = "Green"
            numberColor = R.color.green
            color = Color(nameColor, numberColor)
        } else {
            parseArgs()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            // установка данных
            nameColor = color.name
            numberColor = color.number
            Log.d("msg", "установка данных color.name: ${color.name}, color.number ${color.number}")

            // применяем данные к отрисовке Фрагмента
            tvColor.text = nameColor
//            this.root.setBackgroundColor(numberColor)
            fragmentSecond.setBackgroundColor(resources.getColor(numberColor))

            // Back
            buttonBack.setOnClickListener {
                // обратно на 1 фрагмент
                Log.d("msg", "buttonBack")
                requireActivity().supportFragmentManager.popBackStack(
                    FirstFragment.NAME,
                    FragmentManager.POP_BACK_STACK_INCLUSIVE
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}