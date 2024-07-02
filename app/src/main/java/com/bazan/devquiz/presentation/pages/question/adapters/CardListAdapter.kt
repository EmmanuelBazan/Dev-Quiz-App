package com.bazan.devquiz.presentation.pages.question.adapters

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.animation.doOnEnd
import androidx.recyclerview.widget.RecyclerView
import com.bazan.devquiz.R
import kotlin.math.abs

class CardListAdapter(private val images: List<Int>, private val context: Context) :
    RecyclerView.Adapter<CardListAdapter.ImageViewHolder>() {
    private var downX: Float = 0f
    private var downY: Float = 0f
    private val SWIPE_THRESHOLD = 100


    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val view = itemView
        val cardFront = itemView.findViewById<View>(R.id.card_face_front)
        val cardBack = itemView.findViewById<View>(R.id.card_face_back)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return ImageViewHolder(view)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        var isCardFront = true
        holder.view.setOnTouchListener { _, event ->
            isTap(event, onTap = {
                isCardFront = !isCardFront

                if (isCardFront) {
                    holder.view.isEnabled = false
                    flipCard(context, holder.cardFront, holder.cardBack, holder.view)
                } else {
                    holder.view.isEnabled  = false
                    flipCard(context, holder.cardBack, holder.cardFront, holder.view)
                }
            })
        }
    }

    override fun getItemCount(): Int {
        return images.size
    }

    private fun isTap(event: MotionEvent, onTap: () -> Unit): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                downX = event.x
                downY = event.y
                return true
            }

            MotionEvent.ACTION_UP -> {
                val upX = event.x
                val upY = event.y
                val deltaX = upX - downX
                val deltaY = upY - downY

                if (abs(deltaX) < SWIPE_THRESHOLD && abs(deltaY) < SWIPE_THRESHOLD) {
                    // Es un clic, no un swipe
                    onTap()
                    return true
                }
                return false
            }

            else -> return false
        }
    }

    private fun flipCard(context: Context, visibleView: View, inVisibleView: View, card: View) {
        try {
            visibleView.visibility = View.VISIBLE
            val scale = context.resources.displayMetrics.density
            val cameraDist = 8000F * scale
            visibleView.cameraDistance = cameraDist
            inVisibleView.cameraDistance = cameraDist
            val flipOutAnimatorSet = AnimatorInflater.loadAnimator(context, R.animator.flip_out) as AnimatorSet
            flipOutAnimatorSet.setTarget(inVisibleView)
            val flipInAnimatorSet = AnimatorInflater.loadAnimator(context, R.animator.flip_in) as AnimatorSet
            flipInAnimatorSet.setTarget(visibleView)

            flipOutAnimatorSet.start()
            flipInAnimatorSet.start()
            flipInAnimatorSet.doOnEnd {
                inVisibleView.visibility = View.GONE
                card.isEnabled = true
            }
        } catch (e: Exception) {
            Log.e("FLIP CARD", "flipCard: $e")
        }
    }
}