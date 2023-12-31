package com.london.doubletaptolike

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import com.london.doubletaptolike.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var isLiked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startAnim()
    }

    private fun startAnim() {
        val zoomInAnim = AnimationUtils.loadAnimation(this, R.anim.zoom_in)
        val zoomOutAnim = AnimationUtils.loadAnimation(this, R.anim.zoom_out)
        binding.imageView.setOnClickListener(object : DoubleClickListener(), View.OnClickListener {
            override fun onDoubleClick(v: View?) {
                binding.heart.setImageResource(R.drawable.baseline_favorite_24)
                binding.heart.startAnimation(zoomInAnim)
                binding.insideHeard.startAnimation(zoomInAnim)
                binding.insideHeard.startAnimation(zoomOutAnim)
                isLiked = true
            }
        })

        binding.heart.setOnClickListener {
            if (isLiked) {
                binding.heart.setImageResource(R.drawable.baseline_favorite_border_24)
            } else {
                binding.heart.setImageResource(R.drawable.baseline_favorite_24)
                binding.insideHeard.startAnimation(zoomInAnim)
                binding.insideHeard.startAnimation(zoomOutAnim)
            }

            binding.heart.startAnimation(zoomInAnim)
            isLiked = !isLiked
        }
    }


}