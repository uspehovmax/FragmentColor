package ru.uspehovmax.fragmentcolor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.uspehovmax.fragmentcolor.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var nameColor: String
    private lateinit var currentColor: Color
    private var numberColor: Int = 0

    companion object {
        const val NAME = "FirstFragment"
        private const val BLACK_COLOR = "Black"
        private const val WHITE_COLOR = "White"
        private const val RED_COLOR = "Red"
        private const val BLUE_LIGHT_COLOR = "Blue-light"
        private const val BLUE_DARK_COLOR = "Blue-dark"
        private const val ORANGE_COLOR = "Orange"
        private const val YELLOW_COLOR = "Yellow"
        private const val VIOLET_COLOR = "Violet"
        private const val GREY_COLOR = "Grey"
        private const val GREEN_COLOR = "Green"
    }

    //     для обращения через binding
    private var _binding: FragmentFirstBinding? = null
    val binding: FragmentFirstBinding
        get() = _binding ?: throw RuntimeException("FragmentFirstBinding == null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//     Inflate the layout for this fragment
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            //Black
            buttonBlack.setOnClickListener {
                nameColor = BLACK_COLOR
                numberColor = R.color.black
                currentColor = Color(nameColor, numberColor)
                launchSecondFragment(currentColor)
            }
            //White
            buttonWhite.setOnClickListener {
                nameColor = WHITE_COLOR
                numberColor = R.color.white
                currentColor = Color(nameColor, numberColor)
                launchSecondFragment(currentColor)
            }
            //Grey
            buttonGrey.setOnClickListener {
                nameColor = GREY_COLOR
                numberColor = R.color.grey
                currentColor = Color(nameColor, numberColor)
                launchSecondFragment(currentColor)
            }
            //Red
            buttonRed.setOnClickListener {
                nameColor = RED_COLOR
                numberColor = R.color.red
                currentColor = Color(nameColor, numberColor)
                launchSecondFragment(currentColor)
            }
            //Orange
            buttonOrange.setOnClickListener {
                nameColor = ORANGE_COLOR
                numberColor = R.color.orange
                currentColor = Color(nameColor, numberColor)
                launchSecondFragment(currentColor)
            }
            //Yellow
            buttonYellow.setOnClickListener {
                nameColor = YELLOW_COLOR
                numberColor = R.color.yellow
                currentColor = Color(nameColor, numberColor)
                launchSecondFragment(currentColor)
            }
            //Green
            buttonGreen.setOnClickListener {
                nameColor = GREEN_COLOR
                numberColor = R.color.green
                currentColor = Color(nameColor, numberColor)
                launchSecondFragment(currentColor)
            }
            //Blue-light
            buttonBlueLight.setOnClickListener {
                nameColor = BLUE_LIGHT_COLOR
                numberColor = R.color.blue_light
                currentColor = Color(nameColor, numberColor)
                launchSecondFragment(currentColor)
            }
            //Blue-dark
            buttonBlueDark.setOnClickListener {
                nameColor = BLUE_DARK_COLOR
                numberColor = R.color.blue_dark
                currentColor = Color(nameColor, numberColor)
                launchSecondFragment(currentColor)
            }
            //Violet
            buttonViolet.setOnClickListener {
                nameColor = VIOLET_COLOR
                numberColor = R.color.violet
                currentColor = Color(nameColor, numberColor)
                launchSecondFragment(currentColor)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun launchSecondFragment(color: Color) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, SecondFragment.newInstance(color))
            .addToBackStack(FirstFragment.NAME)
            .commit()
    }
}
