package lab2
import chisel3 . _
import chisel3 . util . _


// object MuxLookup1 extends App{
//     println (( new chisel3 . stage . ChiselStage ) . emitVerilog ( new Main3 () ) )

// }

// class MuxLookup extends Module {
class MuxLookup_bundle extends Bundle{
val in0 = Input ( Bool () )
val in1 = Input ( Bool () )
val in2 = Input ( Bool () )
val in3 = Input ( Bool () )
val in4 = Input ( Bool () )
val in5 = Input ( Bool () )
val in6 = Input ( Bool () )
val in7 = Input ( Bool () )
val sel0 = Input ( UInt (1. W ) )
val sel1 = Input ( UInt (1. W ) )
val sel2 = Input ( UInt (1. W ) )
val out = Output ( Bool () )
}
class Main3 extends Module{
    val io = IO ( new MuxLookup_bundle)
    val MuxLookup_1 = MuxLookup (io.sel1,false.B, Array((0.U) -> MuxLookup(io.sel0,false.B, Array((0.U) -> io.in0, (1.U) -> io.in1)),
     (1.U) -> MuxLookup(io.sel0, false.B, Array((0.U) -> io.in2, (1.U) -> io.in3))))
    val MuxLookup_2 = MuxLookup (io.sel1,false.B, Array((0.U) -> MuxLookup(io.sel0,false.B, Array((0.U) -> io.in4, (1.U) -> io.in5)),
     (1.U) -> MuxLookup(io.sel0, false.B, Array((0.U) -> io.in6, (1.U) -> io.in7))))
     // MuxLookup ( io . select , default , Array ( c1 - > a , c2 - > b , ...) )
    val Muxlookup_3 = MuxLookup (io.sel2,false.B, Array((0.U) -> MuxLookup_1, (1.U) -> MuxLookup_2))
    io.out := Muxlookup_3

}

