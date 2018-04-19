package com.glumes.androidcppsolib.ui


import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import com.glumes.androidcppsolib.base.BaseListActivity
import com.glumes.androidcppsolib.utils.*
import com.glumes.androidcppsolib.binder.SampleBinder
import com.glumes.androidcppsolib.binder.SampleModel
import com.glumes.databindingadapter.DataBindingAdapter
import com.glumes.databindingadapter.Items

class JNIMethodActivity : BaseListActivity() {

    val items = Items()

    override fun initAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder> {

        val mAdapter = DataBindingAdapter()

        mAdapter.map(SampleModel::class.java, SampleBinder()).setItems(items)

        return mAdapter
    }


    override fun onResume() {
        super.onResume()
        initData()
    }

    override fun setUpToolbar(toolbar: Toolbar) {
        toolbar.title = "JNI 方法调用"
    }

    private fun initData() {
        items.add(SampleModel("基本数据类型操作",))
        items.add(SampleModel("native 返回 string 类型", NATIVE_STRING))
        items.add(SampleModel("native 返回 array 类型", NATIVE_INT_ARRAY))
        items.add(SampleModel("native 调用 类 static 方法", NATIVE_CALL_STATIC_METHOD))
        items.add(SampleModel("native 调用 对象实例方法", NATIVE_CALL_INSTANCE_METHOD))
        items.add(SampleModel("native 调用父类方法", NATIVE_CALL_SUPER_METHOD))
        items.add(SampleModel("Cache", NATIVE_ACCESS_CACHE))
    }
}
