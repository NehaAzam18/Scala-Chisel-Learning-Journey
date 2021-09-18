package lab3
import chisel3 . _
import chisel3 . util . _
class LM_IO_Interface_ImmdValGen extends Bundle {
val instr = Input ( UInt (32. W ) )
val immd_sel = Output ( UInt (32. W ) )
}
class task4 extends Module {
val io = IO ( new LM_IO_Interface_ImmdValGen )
val opcode = io.instr(7,0)
io.immd_sel := 0.U
when(opcode === "b0010011".U || opcode === "b0000011".U || opcode === "b1100111".U || opcode === "b1110011".U){ //for I type
    io.immd_sel := io.instr(31,20)
}.elsewhen(opcode === "b0100011".U){ //for S type
    io.immd_sel := Cat(io.instr(11,7), io.instr(31,25))
}.elsewhen(opcode === "b1100011".U){ //for B Type
    io.immd_sel := Cat(io.instr(31,30), io.instr(11,10), io.instr(30,25),io.instr(10,7))
}.elsewhen(opcode === "b0010111".U || opcode === "b0110111".U){ //for U type
    io.immd_sel := io.instr(31,12)
}.elsewhen(opcode === "b1101111".U){ //for J Type
    io.immd_sel := Cat(io.instr(31), io.instr(21,12), io.instr(22),io.instr(30,23))
}
}
