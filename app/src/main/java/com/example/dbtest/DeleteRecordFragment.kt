package com.example.dbtest


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.dbtest.Database.Student
import kotlinx.android.synthetic.main.fragment_add_record.*
import kotlinx.android.synthetic.main.fragment_delete_record.*
import java.lang.Exception

/**
 * A simple [Fragment] subclass.
 */
class DeleteRecordFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_delete_record, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnDelete.setOnClickListener() {

            try{
                val id:String = editText.text.toString()
                val s = Student(id, "", "")

                val count = MainActivity.appDB.studentDao().delete(s)

                if(count != 0){
                    Toast.makeText(context, "Record deleted", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(context, "ID not found", Toast.LENGTH_LONG).show()
                }



            }catch (ex: Exception){
                Toast.makeText(context, ex.message, Toast.LENGTH_LONG).show()
            }

        }
    }
}
