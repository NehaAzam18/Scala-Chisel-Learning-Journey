package lab2
import chisel3 . _
import chisel3 . util . _


// object barrel_shift extends App{
//     println (( new chisel3 . stage . ChiselStage ) . emitVerilog ( new Main6 () ) )

// }

class Main6 extends Module {
val io = IO ( new Bundle {
val in0 = Input (Bool() )
val in1 = Input ( Bool() )
val in2 = Input ( Bool() )
val in3 = Input ( Bool() )
val sel1 = Vec(2, Input( Bool()))
val shift_type = Input ( Bool())
val out0 = Output ( Bool())
val out1 = Output ( Bool())
val out2 = Output ( Bool())
val out3 = Output ( Bool())
})
val sel = Cat(io.sel1(1), io.sel1(0)).asUInt
// Start you code here
io.out0 := MuxCase(false.B, Array( 
(sel === "b00".U) -> io.in0,
(sel === "b01".U) -> io.in1,
(sel === "b10".U) -> io.in2,
(sel === "b11".U) -> io.in3))

io.out1 := MuxCase (false.B, Array( 
(sel === "b00".U) -> io.in1,
(sel === "b01".U) -> io.in2,
(sel === "b10".U) -> io.in3,
(sel === "b11".U) -> Mux(io.shift_type,io.in0, 0.U)))

io.out2 := MuxCase (false.B, Array( 
(sel === "b00".U) -> io.in2,
(sel === "b01".U) -> io.in3,
(sel === "b10".U) -> Mux(io.shift_type,io.in0, 0.U),
(sel === "b11".U) -> Mux(io.shift_type,io.in1, 0.U)))

io.out3 := MuxCase (false.B, Array( 
(sel === "b00".U) -> io.in3,
(sel === "b01".U) -> Mux(io.shift_type,io.in0, 0.U),
(sel === "b10".U) -> Mux(io.shift_type,io.in1, 0.U),
(sel === "b11".U) -> Mux(io.shift_type,io.in2, 0.U)))

}