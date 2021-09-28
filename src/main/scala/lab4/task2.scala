package lab4
import chisel3 . _
import chisel3 . util . _
class LM_IO_Interface_ImmdValGen extends Bundle {
val instr = Input ( UInt (32. W ) )
val immd_sel = Output ( UInt (32. W ) )
}
class task2 extends Module {
val io = IO ( new LM_IO_Interface_ImmdValGen )
val opcode = io.instr(7,0)
val imm_31 = io.instr(31)
val imm_30 = io.instr(30,25)
val imm_24 = io.instr(24,21)
val imm_20 = io.instr(20)
val imm_19 = io.instr(19,12)
val imm_11 = io.instr(11,8)
val imm_7 = io.instr(7)
io.immd_sel := DontCare
when(opcode === "b0010011".U || opcode === "b0000011".U || opcode === "b1100111".U || opcode === "b1110011".U){ //for I type
    io.immd_sel := io.instr(31,20)
   //io.immd_sel := Cat(Fill(20,imm_31),imm_31, imm_30, imm_24, imm_20)
}.elsewhen(opcode === "b0100011".U){ //for S type
    io.immd_sel := Cat(io.instr(31,25), io.instr(11,7))
    //io.immd_sel := Cat(Fill(20,imm_31),imm_31,imm_30, imm_11, imm_7)
}.elsewhen(opcode === "b1100011".U){ //for B Type
    io.immd_sel := Cat(io.instr(31),io.instr(29,25),io.instr(10,7), io.instr(11))
    //io.immd_sel := Cat(Fill(19,imm_31),imm_31,imm_7,imm_30,imm_11, 0.U)
}.elsewhen(opcode === "b0010111".U || opcode === "b0110111".U){ //for U type
    io.immd_sel := io.instr(31,12)
    //io.immd_sel := (Cat(imm_31,imm_30,imm_24,imm_20,imm_19) << 12.U)
}.elsewhen(opcode === "b1101111".U){ //for J Type
    //io.immd_sel := Cat(io.instr(31), io.instr(21,12), io.instr(22),io.instr(30,23))
    //io.immd_sel := Cat(Fill(11,imm_31),imm_31,imm_19,imm_20,imm_30,imm_24, 0.U)
}
}
