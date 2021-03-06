package com.example.liunianyishi.intelligenttransportation.View.ViewReslove

import android.graphics.Rect
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.liunianyishi.intelligenttransportation.Adapter.CarInfoRVAdapter
import com.example.liunianyishi.intelligenttransportation.Bean.illegalCarListBean
import com.example.liunianyishi.intelligenttransportation.Presenter.mPresenter
import com.example.liunianyishi.intelligenttransportation.R

/**
 * Created by qiuchen on 2018/1/31.
 */
class illegalQueryResult(v: View, private val cb: mPresenter.queryCallback) : BaseViewResolve(v), CarInfoRVAdapter.importAllObject {

    private val mAddMore: ImageView = fb(R.id.mSearchResult_AddQuery, true)
    private val mCarsRV: RecyclerView = fb(R.id.mSearchResult_Cars)
    private val mCarDetails: RecyclerView = fb(R.id.mSearchResult_CarDetails)
    private val carInfoAdapter = CarInfoRVAdapter(ArrayList(), mCarsRV, this)

    init {
        mCarsRV.layoutManager = LinearLayoutManager(getContext())
        mCarsRV.setHasFixedSize(false)
        mCarsRV.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
                outRect?.bottom = 5
            }
        })
        mCarsRV.itemAnimator = DefaultItemAnimator()
        mCarsRV.adapter = carInfoAdapter
    }

    fun addAllResultToCarsRv(list: illegalCarListBean) {
        carInfoAdapter.addItem(list)
    }

    fun hasItemEx(id: String): Boolean {
        return carInfoAdapter.hasItem(id)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            mAddMore.id -> {
                cb.retQueryResult(mPresenter.WHO_QUERY_Details, null)
            }
        }
    }
    override fun getDetailsRecyclerV(): RecyclerView {
        return mCarDetails
    }
}
