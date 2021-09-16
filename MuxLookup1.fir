;buildInfoPackage: chisel3, version: 3.4.3, scalaVersion: 2.12.12, sbtVersion: 1.3.10
circuit MuxLookup1 : 
  module MuxLookup1 : 
    input clock : Clock
    input reset : UInt<1>
    output io : {flip in0 : UInt<1>, flip in1 : UInt<1>, flip in2 : UInt<1>, flip in3 : UInt<1>, flip in4 : UInt<1>, flip in5 : UInt<1>, flip in6 : UInt<1>, flip in7 : UInt<1>, flip sel : UInt<3>, out : UInt<1>}
    
    node _MuxLookup_1_T = eq(UInt<1>("h00"), io.sel) @[Mux.scala 80:60]
    node _MuxLookup_1_T_1 = mux(_MuxLookup_1_T, io.in0, UInt<1>("h00")) @[Mux.scala 80:57]
    node _MuxLookup_1_T_2 = eq(UInt<1>("h01"), io.sel) @[Mux.scala 80:60]
    node _MuxLookup_1_T_3 = mux(_MuxLookup_1_T_2, io.in1, _MuxLookup_1_T_1) @[Mux.scala 80:57]
    node _MuxLookup_1_T_4 = eq(UInt<2>("h02"), io.sel) @[Mux.scala 80:60]
    node _MuxLookup_1_T_5 = mux(_MuxLookup_1_T_4, io.in2, _MuxLookup_1_T_3) @[Mux.scala 80:57]
    node _MuxLookup_1_T_6 = eq(UInt<2>("h03"), io.sel) @[Mux.scala 80:60]
    node MuxLookup_1 = mux(_MuxLookup_1_T_6, io.in3, _MuxLookup_1_T_5) @[Mux.scala 80:57]
    node _MuxLookup_2_T = eq(UInt<3>("h04"), io.sel) @[Mux.scala 80:60]
    node _MuxLookup_2_T_1 = mux(_MuxLookup_2_T, io.in4, UInt<1>("h00")) @[Mux.scala 80:57]
    node _MuxLookup_2_T_2 = eq(UInt<3>("h05"), io.sel) @[Mux.scala 80:60]
    node _MuxLookup_2_T_3 = mux(_MuxLookup_2_T_2, io.in5, _MuxLookup_2_T_1) @[Mux.scala 80:57]
    node _MuxLookup_2_T_4 = eq(UInt<3>("h06"), io.sel) @[Mux.scala 80:60]
    node _MuxLookup_2_T_5 = mux(_MuxLookup_2_T_4, io.in6, _MuxLookup_2_T_3) @[Mux.scala 80:57]
    node _MuxLookup_2_T_6 = eq(UInt<3>("h07"), io.sel) @[Mux.scala 80:60]
    node MuxLookup_2 = mux(_MuxLookup_2_T_6, io.in7, _MuxLookup_2_T_5) @[Mux.scala 80:57]
    node _io_out_T = eq(UInt<1>("h00"), io.sel) @[Mux.scala 80:60]
    node _io_out_T_1 = mux(_io_out_T, MuxLookup_1, UInt<1>("h00")) @[Mux.scala 80:57]
    node _io_out_T_2 = eq(UInt<1>("h01"), io.sel) @[Mux.scala 80:60]
    node _io_out_T_3 = mux(_io_out_T_2, MuxLookup_2, _io_out_T_1) @[Mux.scala 80:57]
    io.out <= _io_out_T_3 @[Main3.scala 34:12]
    
