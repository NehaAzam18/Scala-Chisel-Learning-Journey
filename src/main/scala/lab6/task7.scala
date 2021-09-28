// Up - down counter example
package lab6
import chisel3 . _
import chisel3 . util ._
class task7 ( val max : Int = 10) extends Module {
val io = IO ( new Bundle {
val out = Output ( UInt ( log2Ceil ( max ) . W ) )
val up_down = Input ( Bool () )
})
// Start code here
 val counter = RegInit ( 0 . U ( log2Ceil ( max ) . W ) )
when(io.up_down === 1.B){
    //val counter = RegInit ( 0 . U ( log2Ceil ( max ) . W ))
    counter := counter + 1.U
}
.otherwise{
    //val counter = RegInit ( max . U ( log2Ceil ( max ) . W ) )
    counter := max.U
    counter := counter - 1.U
}
 io.out := counter
}




//println (( new chisel3 . stage . ChiselStage ) . emitVerilog ( new up_down_counter (4) ) )