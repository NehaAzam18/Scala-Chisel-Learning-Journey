import chisel3 . _
import chisel3 . util . _


object Main extends App{
    println("Hello World")
    println (( new chisel3 . stage . ChiselStage ) . emitVerilog ( new Mux_2to_1 () ) )
    println (( new chisel3 . stage . ChiselStage ) . emitVerilog ( new Mux_8to1 () ) )
    println (( new chisel3 . stage . ChiselStage ) . emitVerilog ( new Mux_Tree () ) )
    println (( new chisel3 . stage . ChiselStage ) . emitVerilog ( new MuxCase_ex () ) )
    println (( new chisel3 . stage . ChiselStage ) . emitVerilog ( new MuxLookup () ) )
    println (( new chisel3 . stage . ChiselStage ) . emitVerilog ( new mux_onehot_4to1 () ) )
    println (( new chisel3 . stage . ChiselStage ) . emitVerilog ( new Mem_bundle_intf () ) )
}


// Mux IO interface class
class Mux_2to1_IO extends Bundle {
val in_A
= Input ( UInt (32. W ) )
val in_B
= Input ( UInt (32. W ) )
val select = Input ( Bool () )
val out
= Output ( UInt () )
}
// 2 to 1 Mux implementation
class Mux_2to_1 extends Module {
val io = IO ( new Mux_2to1_IO )
// update the output
io . out := Mux ( io . select , io . in_A , io . in_B )
}

class LM_IO_Interface extends Bundle {
val in = Input ( UInt (8. W ) )
val s0 = Input ( Bool () )
val s1 = Input ( Bool () )
val s2 = Input ( Bool () )
val out = Output ( Bool () )
// UInt (1. W ) )
}
class Mux_8to1 extends Module {
val io = IO ( new LM_IO_Interface )
val Mux4_to_1_a = Mux ( io . s1 , Mux ( io . s0 , io . in (3) , io . in (2) ) ,
Mux ( io . s0 , io . in (1) , io . in (0) ) )
val Mux4_to_1_b = Mux ( io . s1 , Mux ( io . s0 , io . in (7) , io . in (6) ) ,
Mux ( io . s0 , io . in (5) , io . in (4) ) )
val Mux2_to_1 = Mux ( io . s2 , Mux4_to_1_b , Mux4_to_1_a )
// Connecting output of 2 _to_1 Mux with the output port .
io . out := Mux2_to_1
}

class IO_Interface extends Bundle {
val in = Input ( UInt (4. W ) )
val s1 = Input ( Bool () )
val s2 = Input ( Bool () )
val s3 = Input ( Bool () )
val out = Output ( Bool () )
// UInt (1. W ) )
}
class Mux_Tree extends Module {
val io = IO ( new IO_Interface )
io . out := Mux ( io . s3 , io . in (3) , Mux ( io . s2 , io . in (2) ,
Mux ( io . s1 , io . in (1) , io . in (0) ) ) )
}

class MuxCase_ex extends Module {
val io = IO ( new Bundle {
val in0 = Input ( Bool () )
val in1 = Input ( Bool () )
val in2 = Input ( Bool () )
val in3 = Input ( Bool () )
val in4 = Input ( Bool () )
val in5 = Input ( Bool () )
val in6 = Input ( Bool () )
val in7 = Input ( Bool () )
val sel = Input ( UInt (3. W ) )
val out = Output ( Bool () )
})
io . out := MuxCase ( false .B , Array (
( io . sel ===0. U ) ->
io . in0 ,
( io . sel ===1. U ) ->
io . in1 ,
( io . sel ===2. U ) ->
io . in2 ,
( io . sel ===3. U ) ->
io . in3 ,
( io . sel ===4. U ) ->
io . in4 ,
( io . sel ===5. U ) ->
io . in5 ,
( io . sel ===6. U ) ->
io . in6 ,
( io . sel ===7. U ) ->
io . in7 )
)
}

class MuxLookup extends Module {
val io = IO ( new Bundle {
val in0 = Input ( Bool () )
val in1 = Input ( Bool () )
val in2 = Input ( Bool () )
val in3 = Input ( Bool () )
val in4 = Input ( Bool () )
val in5 = Input ( Bool () )
val in6 = Input ( Bool () )
val in7 = Input ( Bool () )
val sel = Input ( UInt (3. W ) )
val out = Output ( Bool () )
})
io . out := MuxLookup ( io . sel , false .B , Array (
(0. U ) ->
io . in0 ,
(1. U ) ->
io . in1 ,
(2. U ) ->
io . in2 ,
(3. U ) ->
io . in3 ,
(4. U ) ->
io . in4 ,
(5. U ) ->
io . in5 ,
(6. U ) ->
io . in6 ,
(7. U ) ->
io . in7 )
)
}



class mux_onehot_4to1 extends Module {
val io = IO ( new Bundle {
val in0 = Input ( UInt (32.W ) )
val in1 = Input ( UInt (32.W ) )
val in2 = Input ( UInt (32.W ) )
val in3 = Input ( UInt (32.W ) )
val sel = Input ( UInt (4.W ) )
val out = Output ( UInt (32.W ) )
})
io . out := Mux1H ( io . sel , Seq ( io . in0 , io . in1 , io . in2 , io . in3 ) )
}

class LM_IO_Interfaces extends Bundle {
// Make an input from a Vector of 4 values
val data_in = Input ( Vec (4 ,( UInt (32. W ) ) ) )
// Signal to control which vector is selected
val data_selector = Input ( UInt (2. W ) )
val data_out = Output ( UInt (32. W ) )
val addr = Input ( UInt (5. W ) )
// The signal is high for write
val wr_en = Input ( Bool () )
}
class Mem_bundle_intf extends Module {
val io = IO ( new LM_IO_Interfaces )
io . data_out := 0. U
// Make a memory of 32 X32
val memory = Mem (32 , UInt (32. W ) )
when ( io . wr_en ) {
// Write for wr_en = 1
// Write at memory location addr , with selected data from data_in (Vector )
memory . write ( io . addr , io . data_in ( io . data_selector ) )
} .otherwise {
// Asyncronous read from addr location
io . data_out := memory . read ( io . addr )
}
}

