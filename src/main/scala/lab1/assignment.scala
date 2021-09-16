package lab1
import chisel3 . _
import chisel3 . util . _

import java . io . File
class assignment ( n : Int ) extends Module {
    val io = IO ( new Bundle {
    val data_in = Input ( UInt ( n . W ) )
    val reload = Input ( Bool () )
    val out = Output ( Bool () )
    })
    val counter = RegInit (0. U ( n . W ) )
    val max_count = RegInit (5. U ( n . W ) )
    val flag = RegInit(0.U(n. W))
    // Your code
    when(counter === max_count){
        flag:= 1.U
        //counter := counter - 1.U
    }.elsewhen(counter === 0.U){
        flag := 0.U
        //counter := counter + 1.U
    }
    when(flag === 1.U){
        counter := counter - 1.U
    }
    .elsewhen(flag === 0.U){
        counter := counter + 1.U
    }
        
    io.out := counter(2.U)
    println(s"counter created max value $max_count")
}