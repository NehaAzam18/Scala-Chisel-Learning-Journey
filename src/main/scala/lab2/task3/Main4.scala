package lab2
import chisel3 . _
import chisel3 . util . _


// object mux_onehot_4to2 extends App{
//     println (( new chisel3 . stage . ChiselStage ) . emitVerilog ( new Main4 () ) )
// }

class Main4 extends Module {
val io = IO ( new Bundle {
val in0 = Input ( Bool () )
val in1 = Input ( Bool () )
val in2 = Input ( Bool () )
val in3 = Input ( Bool () )
// val sel = Input ( Bool () )
val out = Output ( UInt (2.W ) )
//val out2 = Output (UInt (32.W))
})
val in = Cat(io.in3, io.in2, io.in1, io.in0)
io . out := Mux1H ( in, Seq (0.U, 1.U, 2.U, 3.U ) )

//io . out := Mux1H ( io.in, Seq ( io.in0, io.in1, io.in2, io.in3 ) )
// io . out2:= Mux1H ( io.in, Seq( io.in0, io.in1, io.in2, io.in3))
}