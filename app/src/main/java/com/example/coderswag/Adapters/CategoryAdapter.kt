package com.example.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.coderswag.Model.Category
import com.example.coderswag.R

class CategoryAdapter(context:Context,categories:List<Category>) : BaseAdapter() {
    val context=context
    val categories=categories
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryview:View
        val holder:ViewHolder
        if (convertView==null){
            categoryview=LayoutInflater.from(context).inflate(R.layout.category_list_item,null)
            holder=ViewHolder()
            holder.categoryImage =categoryview.findViewById(R.id.categoryImage)
            holder.categoryName=categoryview.findViewById(R.id.categoryName)
            println("I exist for the first time!")
            categoryview.tag=holder
        }else{
            holder=convertView.tag as ViewHolder
            categoryview=convertView
            println("Go green,recycle!")
        }
        val category=categories[position]
        val resourceId=context.resources.getIdentifier(category.image,"drawable",context.packageName)
        holder.categoryImage?.setImageResource(resourceId)
        holder.categoryName?.text=category.title
        return categoryview
    }

    override fun getItem(position: Int): Any {
       return categories[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return categories.count()
    }
    private class ViewHolder{
        var categoryImage:ImageView?=null
        var categoryName:TextView?=null
    }
}