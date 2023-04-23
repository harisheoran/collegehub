package com.example.collegehub_beta.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.collegehub_beta.R
import com.example.collegehub_beta.databinding.FragmentOnBoardingScreenBinding

private val onBoardingItemsList = listOf<OnBoardingItem>(
    OnBoardingItem(
        "Subject Notes",
        "Access notes for all your subjects in one place, anytime and anywhere.",
        "on_board_img2.json"
    ),
    OnBoardingItem(
        "Question Papers",
        "Prepare for exams with access to a vast collection of previous years' question papers.",
        "on_board_img1.json"
    ),
    OnBoardingItem(
        "Bookshelf",
        " Explore a vast collection of books on different subjects to enhance your knowledge and excel in your studies.",
        "on_board_img3.json"
    )
)

class OnBoardingScreen : Fragment() {
    private var _binding: FragmentOnBoardingScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentOnBoardingScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val indicator = binding.indicator
        val myAdapter = OnBoardingAdapter(onBoardingItemsList)
        binding.viewPager.adapter = myAdapter
        binding.viewPager.setPageTransformer(SwipeAnimationTransformer())
        indicator.setViewPager(binding.viewPager)

        binding?.viewPager?.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                if (position == myAdapter.itemCount - 1) {
                    val animation = AnimationUtils.loadAnimation(
                        requireActivity(),
                        R.anim.on_boarding_button
                    )
                    binding.buttonNext.animation = animation
                    binding.buttonNext.setIcon(null)
                    binding.buttonNext.text = "Finish"
                    binding.buttonNext.setOnClickListener {
                        findNavController().navigate(R.id.action_onBoardingScreen2_to_loginScreen2)
                    }
                } else {
                    binding.buttonNext.text = "Next"
                    binding.buttonNext.setOnClickListener {
                        binding.viewPager.currentItem.let {
                            binding.viewPager.setCurrentItem(it + 1, true)
                        }
                    }

                }

            }
        })
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

class SwipeAnimationTransformer : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        val absPosition = Math.abs(position)
        page.apply {
            translationX = -position * width
            alpha = 1 - absPosition
            scaleX = 0.5f + (1 - absPosition) * 0.5f
            scaleY = 0.5f + (1 - absPosition) * 0.5f
        }
    }
}
