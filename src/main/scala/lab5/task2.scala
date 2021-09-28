package lab5
import chisel3 . _
import chisel3 . util . _

class MuxBundle [ T <: Data ]( gen : T ) extends Bundle {
val out = Output ( gen.cloneType )
val in1 = Input ( gen.cloneType )
val in2 = Input ( gen.cloneType )
val sel = Input ( Bool () )
}

class task2(size: SInt) extends Module {
val io = IO ( new MuxBundle(size)) 
io . out := Mux2_to_1 ( io . in2 , io . in1 , io . sel )

def Mux2_to_1 [ T <: Data ]( in_0 :T , in_1 :T , sel : Bool ) : T = {
Mux ( sel , in_1 , in_0 )
}
}


//println (( new chisel3 . stage . ChiselStage ) . emitVerilog ( new eMux ( SInt (2. W ) ) ) )