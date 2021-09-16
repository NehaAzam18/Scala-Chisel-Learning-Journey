;buildInfoPackage: chisel3, version: 3.4.3, scalaVersion: 2.12.12, sbtVersion: 1.3.10
circuit MuxCase_ex : 
  module MuxCase_ex : 
    input clock : Clock
    input reset : UInt<1>
    output io : {flip in0 : UInt<1>, flip in1 : UInt<1>, flip in2 : UInt<1>, flip in3 : UInt<1>, flip in4 : UInt<1>, flip in5 : UInt<1>, flip in6 : UInt<1>, flip in7 : UInt<1>, flip sel : UInt<3>, out : UInt<1>}
    
    node _io_out_T = eq(io.sel, UInt<1>("h00")) @[Main.scala 82:12]
    node _io_out_T_1 = eq(io.sel, UInt<1>("h01")) @[Main.scala 84:12]
    node _io_out_T_2 = eq(io.sel, UInt<2>("h02")) @[Main.scala 86:12]
    node _io_out_T_3 = eq(io.sel, UInt<2>("h03")) @[Main.scala 88:12]
    node _io_out_T_4 = eq(io.sel, UInt<3>("h04")) @[Main.scala 90:12]
    node _io_out_T_5 = eq(io.sel, UInt<3>("h05")) @[Main.scala 92:12]
    node _io_out_T_6 = eq(io.sel, UInt<3>("h06")) @[Main.scala 94:12]
    node _io_out_T_7 = eq(io.sel, UInt<3>("h07")) @[Main.scala 96:12]
    node _io_out_T_8 = mux(_io_out_T_7, io.in7, UInt<1>("h00")) @[Mux.scala 98:16]
    node _io_out_T_9 = mux(_io_out_T_6, io.in6, _io_out_T_8) @[Mux.scala 98:16]
    node _io_out_T_10 = mux(_io_out_T_5, io.in5, _io_out_T_9) @[Mux.scala 98:16]
    node _io_out_T_11 = mux(_io_out_T_4, io.in4, _io_out_T_10) @[Mux.scala 98:16]
    node _io_out_T_12 = mux(_io_out_T_3, io.in3, _io_out_T_11) @[Mux.scala 98:16]
    node _io_out_T_13 = mux(_io_out_T_2, io.in2, _io_out_T_12) @[Mux.scala 98:16]
    node _io_out_T_14 = mux(_io_out_T_1, io.in1, _io_out_T_13) @[Mux.scala 98:16]
    node _io_out_T_15 = mux(_io_out_T, io.in0, _io_out_T_14) @[Mux.scala 98:16]
    io.out <= _io_out_T_15 @[Main.scala 81:10]
    
