package ALUtask
import chisel3._ 
import chisel3 . util . _

class ALU extends Module{
    val io = IO(new Bundle{
        val inputA = Input(SInt(32.W))
        val inputB = Input(SInt(32.W))
        val ALU_sel = Input(UInt(4.W))
        val output = Output(SInt(32.W))
    })

val Adder = io.inputA + io.inputB
val Subtractor = (io.inputA - io.inputB)
val AND = io.inputA & io.inputB
val OR = io.inputA | io.inputB
val XOR = io.inputA ^ io.inputB
val SLL = io.inputA << io.inputB(4,0)
val SRA = io.inputA >> io.inputB(4,0)
val SRL = io.inputA >> io.inputB(4,0)
val SLT = io.inputA < io.inputB
val SLTU = (io.inputA < io.inputB).asUInt


io.output := MuxCase ( DontCare , Array (
    ( io.ALU_sel === "b0000".U) -> Adder,
    ( io.ALU_sel === "b0001".U ) -> Subtractor,
    ( io.ALU_sel === "b0010".U ) -> AND,
    ( io.ALU_sel === "b0011".U ) -> OR,
    ( io.ALU_sel === "b0100".U) -> XOR,
    (io.ALU_sel === "b0101".U) -> SLL,
    (io.ALU_sel === "b0110".U) -> SRA,
    (io.ALU_sel === "b0111".U) -> SRL.asSInt,
    (io.ALU_sel === "b1000".U) -> Mux(SLT, 1.S, 0.S),
    (io.ALU_sel === "b1001".U) -> Mux(SLTU.asBool, 1.S, 0.S)))
}