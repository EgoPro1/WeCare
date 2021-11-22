package com.example.wecareapp

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidplot.xy.*
import com.demo.retrofitwithpost.GetEventsVM
import com.example.wecareapp.model.Event
import com.example.wecareapp.model.EventGet
import com.example.wecareapp.model.EventList
import com.example.wecareapp.recyclerview.RecyclerViewAdapter
import com.example.wecareapp.viewmodel.CreateEventVM
import java.text.FieldPosition
import java.text.Format
import java.text.ParsePosition
import java.util.*


class StadisticsFragment : Fragment(){

    // TODO: Rename and change types of parameters

    lateinit var viewModel: GetEventsVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view=inflater.inflate(R.layout.fragment_stadistics, container, false)

        initViewModel()


        // Inflate the layout for this fragment

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FeelingFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StadisticsFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }


    fun initViewModel() {

        viewModel = ViewModelProvider(this).get( GetEventsVM::class.java)
        viewModel.getUserListObserverable().observe(viewLifecycleOwner, Observer<List<EventGet>?> {
            if(it == null) {

            } else {
                var array =ArrayList<Int>()
                var domain=ArrayList<Int>()
                for(e in it){
                    array.add(e.eventScore)
                    var time=e.eventTime.subSequence(0, 2)
                    domain.add(time.toString().toInt())
                }
                //Añado al plot
                updatechart(array,domain)

            }
        })
        viewModel.EventList()
    }

    private fun updatechart(array:ArrayList<Int>,domain:ArrayList<Int>) {
        val list: MutableList<Int> = array.toMutableList()
        val list1: MutableList<Int> = domain.toMutableList()


        val domainLabels = arrayOf<Number>(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24);
        val series1Number = arrayOf<Number>(1,4,8,12,16,32,26,29,10,13);
        val p=Arrays.asList(*list.toTypedArray())
        val q=Arrays.asList(*list1.toTypedArray())
        val series1 : XYSeries = SimpleXYSeries(p,SimpleXYSeries.ArrayFormat.Y_VALS_ONLY
            ,"Series 1");
        val series1Format = LineAndPointFormatter(Color.BLUE,Color.BLACK,null,null)
        series1Format.setInterpolationParams(
            CatmullRomInterpolator.Params(10,
                CatmullRomInterpolator.Type.Centripetal))

        var feeling_today_plot= view?.findViewById<XYPlot>(R.id.feeling_today_plot)

        feeling_today_plot?.addSeries(series1,series1Format)
        feeling_today_plot?.graph?.getLineLabelStyle(XYGraphWidget.Edge.BOTTOM)!!.format = object : Format() {
            override fun format(
                obj: Any?,
                toAppendTo: StringBuffer,
                pos: FieldPosition
            ): StringBuffer {
                val i = Math.round((obj as Number).toFloat())
                return toAppendTo.append(q[i])
            }

            override fun parseObject(source: String?, pos: ParsePosition): Any? {
                return null
            }

        }
        if (feeling_today_plot != null) {
            PanZoom.attach(feeling_today_plot)
        }
    }


}