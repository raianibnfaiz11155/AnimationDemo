package com.nakibul.animationdemo

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {

    private lateinit var star: ImageView
    private lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        star = findViewById(R.id.star)
        text = findViewById(R.id.textview)

        val languages = resources.getStringArray(R.array.options_list)
        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, languages)
        val autocompleteTV = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        autocompleteTV.setAdapter(arrayAdapter)
        var selectedValue: String
        autocompleteTV.setOnItemClickListener { _, _, _, _ ->
            selectedValue = autocompleteTV.text.toString()
            when (selectedValue) {
                Constant.IMAGE_ROTATE -> rotator()
                Constant.IMAGE_TRANSLATE -> translate()
                Constant.IMAGE_SCALE -> scalar()
                Constant.IMAGE_FADE -> fader()
                Constant.IMAGE_SKY_COLOR -> colorized()
                Constant.TEXT_FADE_IN -> fadeInText()
                Constant.TEXT_FADE_OUT -> fadeOutText()
                Constant.TEXT_BOUNCE -> bounceAnimation()
                Constant.TEXT_ROTATE -> rotateAnimation()
                Constant.TEXT_SLIDE_IN -> slideInAnimation()
                Constant.TEXT_SLIDE_OUT -> slideOutAnimation()
                Constant.TEXT_ZOOM_IN -> zoomInAnimation()
                Constant.TEXT_ZOOM_OUT -> zoomOutAnimation()
            }
        }
    }

    private fun rotator() {
        val animator = ObjectAnimator.ofFloat(star, View.ROTATION, 0f,360f)
        animator.repeatCount = 1
        animator.duration = 1000
        animator.repeatMode = ValueAnimator.REVERSE
        animator.start()
    }

    private fun translate() {
        val animator = ObjectAnimator.ofFloat(star, View.TRANSLATION_X, 200f)
        animator.repeatCount = 3
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.start()
    }

    private fun scalar() {
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 4f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 4f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(star, scaleX, scaleY)
        animator.repeatCount = 1
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.start()
    }

    private fun fader() {
        val animator = ObjectAnimator.ofFloat(star, View.ALPHA, 0f)
        animator.repeatCount = 1
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.start()
    }

    @SuppressLint("ObjectAnimatorBinding")
    private fun colorized() {
        val animator = ObjectAnimator.ofArgb(
            star.parent,
            "backgroundColor", Color.WHITE, Color.RED
        )
        animator.duration = 1000
        animator.repeatCount = 3
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.start()
    }

    private fun fadeInText() {
        val fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        text.startAnimation(fadeInAnimation)
    }

    private fun fadeOutText() {
        val fadeOutAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_out)
        text.startAnimation(fadeOutAnimation)
    }

    private fun bounceAnimation() {
        val bounceAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce)
        text.startAnimation(bounceAnimation)
    }

    private fun rotateAnimation() {
        val bounceAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate)
        text.startAnimation(bounceAnimation)
    }

    private fun slideInAnimation() {
        val bounceAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in)
        text.startAnimation(bounceAnimation)
    }

    private fun slideOutAnimation() {
        val bounceAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_out)
        text.startAnimation(bounceAnimation)
    }

    private fun zoomInAnimation() {
        val zoomInAnimation = AnimationUtils.loadAnimation(this, R.anim.zoom_in)
        text.startAnimation(zoomInAnimation)
    }

    private fun zoomOutAnimation() {
        val zoomOutAnimation = AnimationUtils.loadAnimation(this, R.anim.zoom_out)
        text.startAnimation(zoomOutAnimation)
    }

}