<template>
  <div class="CyberBack">
    <Navigation></Navigation>
    <MsgBox03 v-show="errorbox" @HideErrorBox="errorbox=!errorbox"/>

    <div style="left:12%;top:53%;
                width: 500px;height:500px;
                position: absolute;">
      <MsgBox02/>
    </div>
    <div id="central"
         style="left:35%;top:15%;
         width: 600px;height:600px;
         position: absolute;
         z-index:4">
      <svg
          xmlns="http://www.w3.org/2000/svg"
          width="546px" height="501px">
        <defs>
          <filter filterUnits="userSpaceOnUse" id="Filter_0" x="70px" y="251px" width="142px" height="151px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(255, 96, 0)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_1" x="65px" y="62px" width="201px" height="209px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 174, 255)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_2" x="263px" y="267px" width="201px" height="208px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 174, 255)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_3" x="268px" y="62px" width="200px" height="208px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 174, 255)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_4" x="295px" y="205px" width="230px" height="134px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 174, 255)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_5" x="65px" y="260px" width="201px" height="208px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 174, 255)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_6" x="277px" y="97px" width="232px" height="189px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 174, 255)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_7" x="5px" y="205px" width="231px" height="134px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 174, 255)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_8" x="205px" y="6px" width="126px" height="238px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 174, 255)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_9" x="2px" y="146px" width="238px" height="184px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 174, 255)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_10" x="217px" y="3px" width="179px" height="244px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 174, 255)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_11" x="230px" y="8px" width="230px" height="244px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 174, 255)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_12" x="184px" y="168px" width="163px" height="197px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(255, 96, 0)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_13" x="236px" y="48px" width="130px" height="138px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 174, 255)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_14" x="376px" y="100px" width="130px" height="137px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 174, 255)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_15" x="307px" y="203px" width="130px" height="138px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 174, 255)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_16" x="322px" y="325px" width="130px" height="138px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 174, 255)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_17" x="22px" y="204px" width="130px" height="138px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 174, 255)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_18" x="305px" y="52px" width="137px" height="153px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 174, 255)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_19" x="299px" y="47px" width="138px" height="164px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 174, 255)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_20" x="292px" y="43px" width="139px" height="174px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 174, 255)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_21" x="285px" y="42px" width="140px" height="182px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 174, 255)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_22" x="280px" y="51px" width="140px" height="180px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 174, 255)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_23" x="274px" y="61px" width="140px" height="178px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 174, 255)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_24" x="267px" y="72px" width="140px" height="175px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 174, 255)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_25" x="261px" y="81px" width="140px" height="173px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 174, 255)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_26" x="255px" y="92px" width="139px" height="169px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 174, 255)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_27" x="249px" y="102px" width="138px" height="167px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 174, 255)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_28" x="240px" y="36px" width="209px" height="232px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 174, 255)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_29" x="54px" y="103px" width="206px" height="213px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 174, 255)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_30" x="118px" y="136px" width="137px" height="160px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 174, 255)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_31" x="108px" y="128px" width="139px" height="180px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 174, 255)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_32" x="99px" y="120px" width="141px" height="192px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 174, 255)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_33" x="90px" y="113px" width="141px" height="196px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 174, 255)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_34" x="79px" y="110px" width="142px" height="195px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 174, 255)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_35" x="71px" y="124px" width="140px" height="177px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 174, 255)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_36" x="63px" y="140px" width="137px" height="158px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 174, 255)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_37" x="54px" y="250px" width="153px" height="162px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 174, 255)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_38" x="47px" y="248px" width="158px" height="172px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 174, 255)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_39" x="88px" y="69px" width="355px" height="355px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 255, 249)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.45"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_40" x="124px" y="121px" width="283px" height="291px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(255, 96, 0)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_41" x="111px" y="108px" width="309px" height="317px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 174, 255)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_42" x="92px" y="163px" width="409px" height="338px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 174, 255)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_43" x="201px" y="21px" width="135px" height="186px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(255, 96, 0)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_44" x="47px" y="201px" width="167px" height="143px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(255, 96, 0)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_45" x="347px" y="111px" width="146px" height="153px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(255, 96, 0)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_46" x="267px" y="137px" width="159px" height="195px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(255, 6, 0)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_47" x="138px" y="102px" width="188px" height="167px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(255, 6, 0)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_48" x="112px" y="65px" width="208px" height="186px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(0, 174, 255)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_49" x="60px" y="58px" width="132px" height="140px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(255, 96, 0)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_50" x="340px" y="58px" width="132px" height="141px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(255, 96, 0)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_51" x="62px" y="330px" width="132px" height="141px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(255, 96, 0)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_52" x="335px" y="339px" width="133px" height="140px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(255, 96, 0)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_53" x="401px" y="204px" width="130px" height="138px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(255, 96, 0)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_54" x="203px" y="0px" width="130px" height="138px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(255, 96, 0)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_55" x="0px" y="204px" width="129px" height="138px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(255, 96, 0)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_56" x="3px" y="148px" width="131px" height="140px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(255, 96, 0)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_57" x="325px" y="38px" width="133px" height="141px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(255, 96, 0)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>
          <filter filterUnits="userSpaceOnUse" id="Filter_58" x="262px" y="4px" width="132px" height="139px"  >
            <feOffset in="SourceAlpha" dx="0" dy="24" />
            <feGaussianBlur result="blurOut" stdDeviation="7.874" />
            <feFlood flood-color="rgb(255, 96, 0)" result="floodOut" />
            <feComposite operator="atop" in="floodOut" in2="blurOut" />
            <feComponentTransfer><feFuncA type="linear" slope="0.56"/></feComponentTransfer>
            <feMerge>
              <feMergeNode/>
              <feMergeNode in="SourceGraphic"/>
            </feMerge>
          </filter>

        </defs>
        <g filter="url(#Filter_0)">
          <path fill-rule="evenodd"  fill="rgb(255, 102, 0)"
                d="M131.900,296.942 L149.873,298.861 L142.330,315.568 L131.900,296.942 Z"/>
        </g>
        <g filter="url(#Filter_1)">
          <path fill-rule="evenodd"  opacity="0.302" fill="rgb(29, 255, 252)"
                d="M203.124,183.028 L202.079,184.081 L126.448,109.019 L127.492,107.966 L203.124,183.028 Z"/>
        </g>
        <g filter="url(#Filter_2)">
          <path fill-rule="evenodd"  opacity="0.302" fill="rgb(29, 255, 252)"
                d="M401.147,387.493 L400.103,388.546 L324.471,313.484 L325.516,312.431 L401.147,387.493 Z"/>
        </g>
        <g filter="url(#Filter_3)">
          <path fill-rule="evenodd"  opacity="0.302" fill="rgb(29, 255, 252)"
                d="M405.922,108.461 L404.878,107.408 L329.246,182.470 L330.291,183.523 L405.922,108.461 Z"/>
        </g>
        <g filter="url(#Filter_4)">
          <path fill-rule="evenodd"  opacity="0.302" fill="rgb(29, 255, 252)"
                d="M462.760,252.616 L462.766,251.133 L356.205,250.735 L356.199,252.218 L462.760,252.616 Z"/>
        </g>
        <g filter="url(#Filter_5)">
          <path fill-rule="evenodd"  opacity="0.302" fill="rgb(29, 255, 252)"
                d="M203.124,306.185 L202.079,305.132 L126.448,380.194 L127.492,381.247 L203.124,306.185 Z"/>
        </g>
        <g filter="url(#Filter_6)">
          <path fill-rule="evenodd"  stroke="rgb(29, 255, 252)" stroke-width="4px" stroke-linecap="butt" stroke-linejoin="miter" opacity="0.302" fill="none"
                d="M440.894,147.856 L403.117,181.835 L377.276,163.017 L343.851,194.193 "/>
        </g>
        <g filter="url(#Filter_7)">
          <path fill-rule="evenodd"  opacity="0.302" fill="rgb(29, 255, 252)"
                d="M66.886,252.683 L66.880,251.209 L173.350,250.814 L173.356,252.288 L66.886,252.683 Z"/>
        </g>
        <g filter="url(#Filter_8)">
          <path fill-rule="evenodd"  opacity="0.302" fill="rgb(29, 255, 252)"
                d="M268.365,51.223 L266.891,51.217 L266.495,157.677 L267.969,157.683 L268.365,51.223 Z"/>
        </g>
        <g filter="url(#Filter_9)">
          <path fill-rule="evenodd"  stroke="rgb(29, 255, 252)" stroke-width="4px" stroke-linecap="butt" stroke-linejoin="miter" opacity="0.302" fill="none"
                d="M68.456,197.652 L113.274,209.910 L111.493,223.740 L173.221,237.394 "/>
        </g>
        <g filter="url(#Filter_10)">
          <path fill-rule="evenodd"  stroke="rgb(29, 255, 252)" stroke-width="4px" stroke-linecap="butt" stroke-linejoin="miter" opacity="0.302" fill="none"
                d="M327.279,52.921 L313.515,97.297 L299.752,95.050 L284.022,156.277 "/>
        </g>
        <g filter="url(#Filter_11)">
          <path fill-rule="evenodd"  stroke="rgb(29, 255, 252)" stroke-width="4px" stroke-linecap="butt" stroke-linejoin="miter" opacity="0.302" fill="none"
                d="M297.505,160.770 L351.435,60.223 L392.163,88.871 "/>
        </g>
        <g filter="url(#Filter_12)">
          <path fill-rule="evenodd"  fill="rgb(255, 255, 255)"
                d="M284.580,226.430 C284.585,225.758 284.414,225.077 284.052,224.453 C283.699,223.847 283.207,223.370 282.640,223.038 L267.048,214.107 C266.464,213.768 265.784,213.573 265.058,213.573 C264.353,213.573 263.691,213.757 263.118,214.079 L247.528,223.016 C246.940,223.348 246.431,223.835 246.068,224.458 C245.715,225.065 245.545,225.726 245.539,226.380 L245.543,265.029 C245.538,265.701 245.708,266.383 246.071,267.006 C246.125,267.099 246.184,267.188 246.244,267.274 C246.246,267.279 246.248,267.286 246.248,267.286 C246.247,267.286 246.246,267.284 246.244,267.282 C246.577,267.758 247.000,268.142 247.477,268.421 L248.215,268.843 C248.215,268.842 248.215,268.842 248.215,268.841 L265.056,278.451 L265.056,254.138 L253.442,260.785 L283.041,243.823 C283.440,243.520 283.787,243.135 284.055,242.676 C284.393,242.093 284.564,241.460 284.582,240.832 L284.580,226.430 Z"/>
        </g>
        <g filter="url(#Filter_13)">
          <path fill-rule="evenodd"  fill="rgb(32, 197, 255)"
                d="M301.532,94.132 C303.043,94.731 303.786,96.444 303.190,97.958 C302.595,99.471 300.887,100.212 299.375,99.613 C297.864,99.014 297.121,97.301 297.717,95.787 C298.313,94.274 300.021,93.533 301.532,94.132 Z"/>
        </g>
        <g filter="url(#Filter_14)">
          <path fill-rule="evenodd"  fill="rgb(32, 197, 255)"
                d="M441.974,145.248 C443.486,145.848 444.228,147.561 443.632,149.074 C443.037,150.588 441.329,151.329 439.817,150.729 C438.306,150.130 437.564,148.417 438.159,146.903 C438.755,145.390 440.463,144.649 441.974,145.248 Z"/>
        </g>
        <g filter="url(#Filter_15)">
          <path fill-rule="evenodd"  fill="rgb(32, 197, 255)"
                d="M372.596,248.885 C374.107,249.484 374.850,251.197 374.254,252.711 C373.658,254.224 371.950,254.965 370.439,254.366 C368.928,253.767 368.185,252.054 368.781,250.540 C369.376,249.027 371.084,248.286 372.596,248.885 Z"/>
        </g>
        <g filter="url(#Filter_16)">
          <path fill-rule="evenodd"  fill="rgb(32, 197, 255)"
                d="M387.763,370.497 C389.275,371.096 390.017,372.809 389.422,374.323 C388.826,375.836 387.118,376.577 385.607,375.978 C384.095,375.378 383.353,373.665 383.949,372.152 C384.544,370.638 386.252,369.897 387.763,370.497 Z"/>
        </g>
        <g filter="url(#Filter_17)">
          <path fill-rule="evenodd"  fill="rgb(32, 197, 255)"
                d="M87.217,250.008 C88.728,250.608 89.471,252.321 88.875,253.834 C88.280,255.348 86.572,256.089 85.060,255.490 C83.549,254.890 82.806,253.177 83.402,251.664 C83.998,250.150 85.706,249.409 87.217,250.008 Z"/>
        </g>
        <g filter="url(#Filter_18)">
          <path fill-rule="evenodd"  stroke="rgb(29, 255, 252)" stroke-width="4px" stroke-linecap="butt" stroke-linejoin="miter" opacity="0.302" fill="none"
                d="M372.501,102.071 L373.625,113.867 "/>
        </g>
        <g filter="url(#Filter_19)">
          <path fill-rule="evenodd"  stroke="rgb(29, 255, 252)" stroke-width="4px" stroke-linecap="butt" stroke-linejoin="miter" opacity="0.302" fill="none"
                d="M366.602,97.016 L368.569,120.046 "/>
        </g>
        <g filter="url(#Filter_20)">
          <path fill-rule="evenodd"  stroke="rgb(29, 255, 252)" stroke-width="4px" stroke-linecap="butt" stroke-linejoin="miter" opacity="0.302" fill="none"
                d="M359.861,92.803 L362.951,126.506 "/>
        </g>
        <g filter="url(#Filter_21)">
          <path fill-rule="evenodd"  stroke="rgb(29, 255, 252)" stroke-width="4px" stroke-linecap="butt" stroke-linejoin="miter" opacity="0.302" fill="none"
                d="M352.839,91.398 L356.771,133.246 "/>
        </g>
        <g filter="url(#Filter_22)">
          <path fill-rule="evenodd"  stroke="rgb(29, 255, 252)" stroke-width="4px" stroke-linecap="butt" stroke-linejoin="miter" opacity="0.302" fill="none"
                d="M347.221,100.386 L351.154,140.549 "/>
        </g>
        <g filter="url(#Filter_23)">
          <path fill-rule="evenodd"  stroke="rgb(29, 255, 252)" stroke-width="4px" stroke-linecap="butt" stroke-linejoin="miter" opacity="0.302" fill="none"
                d="M341.323,110.497 L345.255,147.851 "/>
        </g>
        <g filter="url(#Filter_24)">
          <path fill-rule="evenodd"  stroke="rgb(29, 255, 252)" stroke-width="4px" stroke-linecap="butt" stroke-linejoin="miter" opacity="0.302" fill="none"
                d="M334.862,121.731 L338.795,156.277 "/>
        </g>
        <g filter="url(#Filter_25)">
          <path fill-rule="evenodd"  stroke="rgb(29, 255, 252)" stroke-width="4px" stroke-linecap="butt" stroke-linejoin="miter" opacity="0.302" fill="none"
                d="M328.683,131.000 L332.615,163.298 "/>
        </g>
        <g filter="url(#Filter_26)">
          <path fill-rule="evenodd"  stroke="rgb(29, 255, 252)" stroke-width="4px" stroke-linecap="butt" stroke-linejoin="miter" opacity="0.302" fill="none"
                d="M322.504,141.391 L325.874,170.601 "/>
        </g>
        <g filter="url(#Filter_27)">
          <path fill-rule="evenodd"  stroke="rgb(29, 255, 252)" stroke-width="4px" stroke-linecap="butt" stroke-linejoin="miter" opacity="0.302" fill="none"
                d="M316.043,151.783 L318.571,177.903 "/>
        </g>
        <g filter="url(#Filter_28)">
          <path fill-rule="evenodd"  stroke="rgb(29, 255, 252)" stroke-width="4px" stroke-linecap="butt" stroke-linejoin="miter" opacity="0.302" fill="none"
                d="M307.617,165.545 L354.805,88.871 L379.242,107.127 L321.661,175.937 "/>
        </g>
        <g filter="url(#Filter_29)">
          <path fill-rule="evenodd"  stroke="rgb(29, 255, 252)" stroke-width="4px" stroke-linecap="butt" stroke-linejoin="miter" opacity="0.302" fill="none"
                d="M177.258,223.769 L122.691,203.037 L148.828,155.752 L192.735,191.103 "/>
        </g>
        <g filter="url(#Filter_30)">
          <path fill-rule="evenodd"  stroke="rgb(29, 255, 252)" stroke-width="4px" stroke-linecap="butt" stroke-linejoin="miter" opacity="0.302" fill="none"
                d="M185.151,185.205 L186.836,205.146 "/>
        </g>
        <g filter="url(#Filter_31)">
          <path fill-rule="evenodd"  stroke="rgb(29, 255, 252)" stroke-width="4px" stroke-linecap="butt" stroke-linejoin="miter" opacity="0.302" fill="none"
                d="M175.882,177.341 L178.972,217.785 "/>
        </g>
        <g filter="url(#Filter_32)">
          <path fill-rule="evenodd"  stroke="rgb(29, 255, 252)" stroke-width="4px" stroke-linecap="butt" stroke-linejoin="miter" opacity="0.302" fill="none"
                d="M166.613,169.758 L171.107,220.874 "/>
        </g>
        <g filter="url(#Filter_33)">
          <path fill-rule="evenodd"  stroke="rgb(29, 255, 252)" stroke-width="4px" stroke-linecap="butt" stroke-linejoin="miter" opacity="0.302" fill="none"
                d="M157.343,162.737 L162.680,218.066 "/>
        </g>
        <g filter="url(#Filter_34)">
          <path fill-rule="evenodd"  stroke="rgb(29, 255, 252)" stroke-width="4px" stroke-linecap="butt" stroke-linejoin="miter" opacity="0.302" fill="none"
                d="M146.951,159.366 L152.849,214.414 "/>
        </g>
        <g filter="url(#Filter_35)">
          <path fill-rule="evenodd"  stroke="rgb(29, 255, 252)" stroke-width="4px" stroke-linecap="butt" stroke-linejoin="miter" opacity="0.302" fill="none"
                d="M138.805,173.971 L142.457,210.763 "/>
        </g>
        <g filter="url(#Filter_36)">
          <path fill-rule="evenodd"  stroke="rgb(29, 255, 252)" stroke-width="4px" stroke-linecap="butt" stroke-linejoin="miter" opacity="0.302" fill="none"
                d="M130.098,189.980 L131.502,207.112 "/>
        </g>
        <g filter="url(#Filter_37)">
          <path fill-rule="evenodd"  stroke="rgb(29, 255, 252)" stroke-width="8px" stroke-linecap="butt" stroke-linejoin="miter" opacity="0.302" fill="none"
                d="M127.405,305.226 L133.361,315.470 "/>
        </g>
        <g filter="url(#Filter_38)">
          <path fill-rule="evenodd"  stroke="rgb(29, 255, 252)" stroke-width="8px" stroke-linecap="butt" stroke-linejoin="miter" opacity="0.302" fill="none"
                d="M119.932,303.102 L131.354,323.197 "/>
        </g>
        <g filter="url(#Filter_39)">
          <path fill-rule="evenodd"  stroke="rgb(29, 255, 252)" stroke-width="5px" stroke-linecap="butt" stroke-linejoin="miter" opacity="0.2" fill="none"
                d="M265.189,186.715 C297.864,186.715 324.353,213.197 324.353,245.865 C324.353,278.532 297.864,305.015 265.189,305.015 C232.515,305.015 206.026,278.532 206.026,245.865 C206.026,213.197 232.515,186.715 265.189,186.715 Z"/>
        </g>
        <g filter="url(#Filter_40)">
          <path fill-rule="evenodd"  stroke="rgb(255, 102, 0)" stroke-width="5px" stroke-dasharray="20, 10" stroke-linecap="butt" stroke-linejoin="miter" fill="none"
                d="M265.189,174.192 C304.795,174.192 336.902,206.287 336.902,245.878 C336.902,285.469 304.795,317.564 265.189,317.564 C225.584,317.564 193.477,285.469 193.477,245.878 C193.477,206.287 225.584,174.192 265.189,174.192 Z"/>
        </g>
        <g filter="url(#Filter_41)">
          <path fill-rule="evenodd"  opacity="0.2" fill="rgb(32, 197, 255)"
                d="M330.297,311.243 C294.249,347.288 235.594,347.288 199.546,311.243 C163.497,275.198 163.497,216.549 199.546,180.504 C235.594,144.458 294.249,144.458 330.297,180.504 C366.346,216.549 366.346,275.198 330.297,311.243 ZM204.358,185.316 C170.964,218.707 170.964,273.039 204.358,306.430 C237.753,339.822 292.090,339.822 325.484,306.430 C358.879,273.039 358.879,218.707 325.484,185.316 C292.090,151.925 237.753,151.925 204.358,185.316 Z"/>
        </g>
        <g filter="url(#Filter_42)" @click="expand04">
          <path id="module42" fill-rule="evenodd"  stroke="rgb(32, 197, 255)" stroke-width="30px" stroke-linecap="butt" stroke-linejoin="miter" opacity="0.302" fill="none"
                d="M393.087,238.849 C393.087,288.238 365.584,331.214 325.032,353.346 C306.450,363.488 285.128,369.253 262.458,369.253 C236.457,369.253 212.231,361.670 191.877,348.599 "/>
        </g>
        <g filter="url(#Filter_43)">
          <path fill-rule="evenodd"  fill="rgb(255, 102, 0)"
                d="M267.736,66.971 C270.687,66.971 273.079,69.363 273.079,72.314 L273.079,115.554 C273.079,118.504 270.687,120.896 267.736,120.896 C264.785,120.896 262.393,118.504 262.393,115.554 L262.393,72.314 C262.393,69.363 264.785,66.971 267.736,66.971 Z"/>
        </g>
        <g filter="url(#Filter_44)">
          <path fill-rule="evenodd"  fill="rgb(255, 102, 0)"
                d="M114.085,246.731 L145.826,246.731 C148.770,246.731 151.156,249.117 151.156,252.061 C151.156,255.004 148.770,257.390 145.826,257.390 L114.085,257.390 C111.142,257.390 108.756,255.004 108.756,252.061 C108.756,249.117 111.142,246.731 114.085,246.731 Z"/>
        </g>
        <g filter="url(#Filter_45)">
          <path fill-rule="evenodd"  fill="rgb(255, 102, 0)"
                d="M428.262,157.375 L429.743,158.997 C430.456,159.753 430.585,160.789 430.032,161.310 L412.800,177.552 C412.247,178.074 411.220,177.884 410.508,177.128 L409.027,175.506 C408.314,174.750 408.185,173.714 408.738,173.193 L425.970,156.951 C426.523,156.429 427.549,156.619 428.262,157.375 Z"/>
        </g>
        <g  filter="url(#Filter_46)" @click="expand01">
          <path id="module46" fill-rule="evenodd"  fill="rgb(248, 12, 34)"
                d="M362.915,245.879 L348.381,244.946 C348.901,235.828 347.610,226.790 344.544,218.085 C341.121,208.367 335.752,199.767 328.587,192.527 L338.851,182.156 C347.569,190.965 354.097,201.418 358.256,213.224 C361.980,223.798 363.547,234.784 362.915,245.879 Z"/>
        </g>
        <g filter="url(#Filter_47)" @click="expand03">
          <path id="module47" fill-rule="evenodd"  fill="rgb(248, 12, 34)"
                d="M263.517,147.984 L262.584,162.554 C253.460,162.032 244.416,163.326 235.705,166.400 C225.981,169.831 217.376,175.213 210.131,182.396 L199.753,172.107 C208.568,163.367 219.028,156.823 230.842,152.654 C241.423,148.921 252.416,147.350 263.517,147.984 Z"/>
        </g>
        <g filter="url(#Filter_48)">
          <path fill-rule="evenodd"  opacity="0.2" fill="rgb(32, 197, 255)"
                d="M256.215,110.216 L257.900,138.864 C248.776,138.342 233.302,141.536 224.756,145.042 C215.960,148.651 202.508,157.801 195.263,164.983 L173.635,143.357 C182.450,134.618 201.426,121.968 213.239,117.799 C223.820,114.066 245.113,109.582 256.215,110.216 Z"/>
        </g>
        <g filter="url(#Filter_49)">
          <path fill-rule="evenodd"  fill="rgb(255, 102, 0)"
                d="M121.570,107.279 L125.762,103.088 L129.953,107.279 L125.762,111.470 L121.570,107.279 Z"/>
        </g>
        <g filter="url(#Filter_50)">
          <path fill-rule="evenodd"  fill="rgb(255, 102, 0)"
                d="M401.302,107.833 L405.493,103.642 L409.684,107.833 L405.493,112.024 L401.302,107.833 Z"/>
        </g>
        <g filter="url(#Filter_51)" @click="expand02">
          <image class="wave"  x="104px" y="355px" width="48px" height="50px"  xlink:href="data:img/png;base64,iVBORw0KGgoAAAANSUhEUgAAADAAAAAyCAMAAAAtFKi+AAAABGdBTUEAALGPC/xhBQAAACBjSFJNAAB6JgAAgIQAAPoAAACA6AAAdTAAAOpgAAA6mAAAF3CculE8AAABmFBMVEX/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD///8XTVm2AAAAh3RSTlMAAytbdYJyYFROTVFea3p8Y0AEC0l0biQBGDpphFcdOHdnSn5LDw1tEglVHCUuGYMGRigIVj5fBTd5cTN2EV0/EJcxmkyFmYcjMm9se0Efn5ioBw4paH2eLMjm+fbiwBWSNlllgJQCmzk7Uh5/E3MMG5BwlRoWozRajCFYF1xIgWQUakdFCkK4E8TNAAAAAWJLR0SH+9kLywAAAAd0SU1FB+UEEhUtKxO223EAAAHcSURBVEjHlZVXV8JAEIUHhBhBYwWCFQWNqAgCFuwFrGDvvXeNDXtvv9sgFshJmd2H2Zl77rclJ7sLkNw02hSdnkql0wzG9AwmMys7B5Rabp7JbLT8law1v6CwqFjeX2IrtYg1a5ndUS5tr+CoSindWcVUS+k1jEtu5lo37RFrbJ3OK79WX3qKWPL6WcXPUd/QmFQ3BRpBuRmaE6sWvZofwEEnFK1tqn4A6v+Tt3cg/NDZlfuTdfdg/ADB0E/SW40DoK//uxsYRPoBuO9oZ9HAUKcQ2DDaD8agEPwRPDA8IpyY0Qo8AGPjMNGrIQDoCEyG8HsG8FAwRRP4AaZhZpYIyIS5CUJgnsgvLGmBFFgkBZZIgeUVIsAOq2uEwPoGEbAJ1q1tAn+5GTw7TgIgdRfY0DDez44J99fePh442IrFQzwQjB1RaD5CA8d8LJ6cYv2+s3jvrkcC5xfxPnqJO9Z+0292dY3xV57yf7lZiwCY6H8evblVs7N3eYnlvV3tL3/ISt6oc+pecfzHoFiqCTjkb7QVTuL28m3QcjeO9ykiNZjGELqS0o+eGbk38+VV/8YnS9vadveewptsWQ9Q720f8YlyeJcxbPtUeZL53YfNgGmQ48yULXyWNile5Be5nT7FAPYGRgAAAABJRU5ErkJggg==" />
          <circle id="module51" cx="128" cy="380" r="4" stroke="none"
                  stroke-width="2" fill="rgb(255, 102, 0)"/>
<!--          <path fill-rule="evenodd"  fill="rgb(255, 102, 0)"-->
<!--                d="M123.598,379.895 L127.789,375.704 L131.980,379.895 L127.789,384.085 L123.598,379.895 Z"/>-->
        </g>
        <g filter="url(#Filter_52)">

          <path fill-rule="evenodd"  fill="rgb(255, 102, 0)"
                d="M396.891,388.616 L401.082,384.425 L405.273,388.616 L401.082,392.807 L396.891,388.616 Z"/>
        </g>
        <g filter="url(#Filter_53)">
          <path fill-rule="evenodd"  fill="rgb(255, 102, 0)"
                d="M462.725,255.083 L462.725,249.157 L468.653,249.157 L468.653,255.083 L462.725,255.083 Z"/>
        </g>
        <g filter="url(#Filter_54)">
          <path fill-rule="evenodd"  fill="rgb(255, 102, 0)"
                d="M270.818,51.258 L264.926,51.258 L264.926,45.337 L270.818,45.336 L270.818,51.258 Z"/>
        </g>
        <g filter="url(#Filter_55)">
          <path fill-rule="evenodd"  fill="rgb(255, 102, 0)"
                d="M66.921,255.136 L66.921,249.244 L60.999,249.244 L60.999,255.136 L66.921,255.136 Z"/>
        </g>
        <g filter="url(#Filter_56)">
          <path fill-rule="evenodd"  fill="rgb(255, 102, 0)"
                d="M71.872,195.315 L70.540,201.054 L64.771,199.715 L66.103,193.976 L71.872,195.315 Z"/>
        </g>
        <g filter="url(#Filter_57)">
          <path fill-rule="evenodd"  fill="rgb(255, 102, 0)"
                d="M386.882,88.719 L390.386,83.939 L395.166,87.442 L391.662,92.223 L386.882,88.719 Z"/>
        </g>
        <g filter="url(#Filter_58)">
          <path fill-rule="evenodd"  fill="rgb(255, 102, 0)"
                d="M329.499,56.414 L323.808,54.889 L325.341,49.169 L331.032,50.694 L329.499,56.414 Z"/>
        </g>

        <image class="wave" x="377px" y="362px" width="48px" height="50px"  xlink:href="data:img/png;base64,iVBORw0KGgoAAAANSUhEUgAAADAAAAAyCAMAAAAtFKi+AAAABGdBTUEAALGPC/xhBQAAACBjSFJNAAB6JgAAgIQAAPoAAACA6AAAdTAAAOpgAAA6mAAAF3CculE8AAABmFBMVEX/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD///8XTVm2AAAAh3RSTlMAAytbdYJyYFROTVFea3p8Y0AEC0l0biQBGDpphFcdOHdnSn5LDw1tEglVHCUuGYMGRigIVj5fBTd5cTN2EV0/EJcxmkyFmYcjMm9se0Efn5ioBw4paH2eLMjm+fbiwBWSNlllgJQCmzk7Uh5/E3MMG5BwlRoWozRajCFYF1xIgWQUakdFCkK4E8TNAAAAAWJLR0SH+9kLywAAAAd0SU1FB+UEEhUtKxO223EAAAHcSURBVEjHlZVXV8JAEIUHhBhBYwWCFQWNqAgCFuwFrGDvvXeNDXtvv9sgFshJmd2H2Zl77rclJ7sLkNw02hSdnkql0wzG9AwmMys7B5Rabp7JbLT8law1v6CwqFjeX2IrtYg1a5ndUS5tr+CoSindWcVUS+k1jEtu5lo37RFrbJ3OK79WX3qKWPL6WcXPUd/QmFQ3BRpBuRmaE6sWvZofwEEnFK1tqn4A6v+Tt3cg/NDZlfuTdfdg/ADB0E/SW40DoK//uxsYRPoBuO9oZ9HAUKcQ2DDaD8agEPwRPDA8IpyY0Qo8AGPjMNGrIQDoCEyG8HsG8FAwRRP4AaZhZpYIyIS5CUJgnsgvLGmBFFgkBZZIgeUVIsAOq2uEwPoGEbAJ1q1tAn+5GTw7TgIgdRfY0DDez44J99fePh442IrFQzwQjB1RaD5CA8d8LJ6cYv2+s3jvrkcC5xfxPnqJO9Z+0292dY3xV57yf7lZiwCY6H8evblVs7N3eYnlvV3tL3/ISt6oc+pecfzHoFiqCTjkb7QVTuL28m3QcjeO9ykiNZjGELqS0o+eGbk38+VV/8YnS9vadveewptsWQ9Q720f8YlyeJcxbPtUeZL53YfNgGmQ48yULXyWNile5Be5nT7FAPYGRgAAAABJRU5ErkJggg==" />
        <image class="wave" x="43px" y="172px" width="48px" height="50px"  xlink:href="data:img/png;base64,iVBORw0KGgoAAAANSUhEUgAAADAAAAAyCAMAAAAtFKi+AAAABGdBTUEAALGPC/xhBQAAACBjSFJNAAB6JgAAgIQAAPoAAACA6AAAdTAAAOpgAAA6mAAAF3CculE8AAABmFBMVEX/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD///8XTVm2AAAAh3RSTlMAAytbdYJyYFROTVFea3p8Y0AEC0l0biQBGDpphFcdOHdnSn5LDw1tEglVHCUuGYMGRigIVj5fBTd5cTN2EV0/EJcxmkyFmYcjMm9se0Efn5ioBw4paH2eLMjm+fbiwBWSNlllgJQCmzk7Uh5/E3MMG5BwlRoWozRajCFYF1xIgWQUakdFCkK4E8TNAAAAAWJLR0SH+9kLywAAAAd0SU1FB+UEEhUtLI3STtIAAAHcSURBVEjHlZVXV8JAEIUHhBhBYwWCFQWNqAgCFuwFrGDvvXeNDXtvv9sgFshJmd2H2Zl77rclJ7sLkNw02hSdnkql0wzG9AwmMys7B5Rabp7JbLT8law1v6CwqFjeX2IrtYg1a5ndUS5tr+CoSindWcVUS+k1jEtu5lo37RFrbJ3OK79WX3qKWPL6WcXPUd/QmFQ3BRpBuRmaE6sWvZofwEEnFK1tqn4A6v+Tt3cg/NDZlfuTdfdg/ADB0E/SW40DoK//uxsYRPoBuO9oZ9HAUKcQ2DDaD8agEPwRPDA8IpyY0Qo8AGPjMNGrIQDoCEyG8HsG8FAwRRP4AaZhZpYIyIS5CUJgnsgvLGmBFFgkBZZIgeUVIsAOq2uEwPoGEbAJ1q1tAn+5GTw7TgIgdRfY0DDez44J99fePh442IrFQzwQjB1RaD5CA8d8LJ6cYv2+s3jvrkcC5xfxPnqJO9Z+0292dY3xV57yf7lZiwCY6H8evblVs7N3eYnlvV3tL3/ISt6oc+pecfzHoFiqCTjkb7QVTuL28m3QcjeO9ykiNZjGELqS0o+eGbk38+VV/8YnS9vadveewptsWQ9Q720f8YlyeJcxbPtUeZL53YfNgGmQ48yULXyWNile5Be5nT7FAPYGRgAAAABJRU5ErkJggg==" />
        <image class="wave" x="102px" y="81px" width="48px" height="50px"  xlink:href="data:img/png;base64,iVBORw0KGgoAAAANSUhEUgAAADAAAAAyCAMAAAAtFKi+AAAABGdBTUEAALGPC/xhBQAAACBjSFJNAAB6JgAAgIQAAPoAAACA6AAAdTAAAOpgAAA6mAAAF3CculE8AAABmFBMVEX/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD///8XTVm2AAAAh3RSTlMAAytbdYJyYFROTVFea3p8Y0AEC0l0biQBGDpphFcdOHdnSn5LDw1tEglVHCUuGYMGRigIVj5fBTd5cTN2EV0/EJcxmkyFmYcjMm9se0Efn5ioBw4paH2eLMjm+fbiwBWSNlllgJQCmzk7Uh5/E3MMG5BwlRoWozRajCFYF1xIgWQUakdFCkK4E8TNAAAAAWJLR0SH+9kLywAAAAd0SU1FB+UEEhUtLI3STtIAAAHcSURBVEjHlZVXV8JAEIUHhBhBYwWCFQWNqAgCFuwFrGDvvXeNDXtvv9sgFshJmd2H2Zl77rclJ7sLkNw02hSdnkql0wzG9AwmMys7B5Rabp7JbLT8law1v6CwqFjeX2IrtYg1a5ndUS5tr+CoSindWcVUS+k1jEtu5lo37RFrbJ3OK79WX3qKWPL6WcXPUd/QmFQ3BRpBuRmaE6sWvZofwEEnFK1tqn4A6v+Tt3cg/NDZlfuTdfdg/ADB0E/SW40DoK//uxsYRPoBuO9oZ9HAUKcQ2DDaD8agEPwRPDA8IpyY0Qo8AGPjMNGrIQDoCEyG8HsG8FAwRRP4AaZhZpYIyIS5CUJgnsgvLGmBFFgkBZZIgeUVIsAOq2uEwPoGEbAJ1q1tAn+5GTw7TgIgdRfY0DDez44J99fePh442IrFQzwQjB1RaD5CA8d8LJ6cYv2+s3jvrkcC5xfxPnqJO9Z+0292dY3xV57yf7lZiwCY6H8evblVs7N3eYnlvV3tL3/ISt6oc+pecfzHoFiqCTjkb7QVTuL28m3QcjeO9ykiNZjGELqS0o+eGbk38+VV/8YnS9vadveewptsWQ9Q720f8YlyeJcxbPtUeZL53YfNgGmQ48yULXyWNile5Be5nT7FAPYGRgAAAABJRU5ErkJggg==" />
        <image class="wave" x="243px" y="23px" width="48px" height="50px"  xlink:href="data:img/png;base64,iVBORw0KGgoAAAANSUhEUgAAADAAAAAyCAMAAAAtFKi+AAAABGdBTUEAALGPC/xhBQAAACBjSFJNAAB6JgAAgIQAAPoAAACA6AAAdTAAAOpgAAA6mAAAF3CculE8AAABmFBMVEX/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD/ZgD///8XTVm2AAAAh3RSTlMAAytbdYJyYFROTVFea3p8Y0AEC0l0biQBGDpphFcdOHdnSn5LDw1tEglVHCUuGYMGRigIVj5fBTd5cTN2EV0/EJcxmkyFmYcjMm9se0Efn5ioBw4paH2eLMjm+fbiwBWSNlllgJQCmzk7Uh5/E3MMG5BwlRoWozRajCFYF1xIgWQUakdFCkK4E8TNAAAAAWJLR0SH+9kLywAAAAd0SU1FB+UEEhUtLI3STtIAAAHcSURBVEjHlZVXV8JAEIUHhBhBYwWCFQWNqAgCFuwFrGDvvXeNDXtvv9sgFshJmd2H2Zl77rclJ7sLkNw02hSdnkql0wzG9AwmMys7B5Rabp7JbLT8law1v6CwqFjeX2IrtYg1a5ndUS5tr+CoSindWcVUS+k1jEtu5lo37RFrbJ3OK79WX3qKWPL6WcXPUd/QmFQ3BRpBuRmaE6sWvZofwEEnFK1tqn4A6v+Tt3cg/NDZlfuTdfdg/ADB0E/SW40DoK//uxsYRPoBuO9oZ9HAUKcQ2DDaD8agEPwRPDA8IpyY0Qo8AGPjMNGrIQDoCEyG8HsG8FAwRRP4AaZhZpYIyIS5CUJgnsgvLGmBFFgkBZZIgeUVIsAOq2uEwPoGEbAJ1q1tAn+5GTw7TgIgdRfY0DDez44J99fePh442IrFQzwQjB1RaD5CA8d8LJ6cYv2+s3jvrkcC5xfxPnqJO9Z+0292dY3xV57yf7lZiwCY6H8evblVs7N3eYnlvV3tL3/ISt6oc+pecfzHoFiqCTjkb7QVTuL28m3QcjeO9ykiNZjGELqS0o+eGbk38+VV/8YnS9vadveewptsWQ9Q720f8YlyeJcxbPtUeZL53YfNgGmQ48yULXyWNile5Be5nT7FAPYGRgAAAABJRU5ErkJggg==" />
        <text kerning="auto" font-family="Myriad Pro" fill="rgb(0, 0, 0)" transform="matrix( 0.79025261482169, 0.28514692273502, -0.28514692273502, 0.79025261482169,339.071118662339, 204.187280368929) rotate(47)" font-size="20px"><tspan font-size="18px" font-family="Bebas Neue" fill="#FFFFFF">Click</tspan></text>
        <text kerning="auto" font-family="Myriad Pro" fill="rgb(0, 0, 0)" transform="matrix( 0.79025261482169, 0.28514692273502, -0.28514692273502, 0.79025261482169,210.071118662339, 177.87280368929) rotate(-50)" font-size="20px"><tspan font-size="18px" font-family="Bebas Neue" fill="rgb(0,0,0)">Error</tspan></text>

      </svg>
    </div>
    <div style="left:63%;top:5%;
                width: 500px;height:500px;
                position: absolute">
      <MsgBox01/>
    </div>
    <div style="left:63%;top:40%;
                width: 500px;height:500px;
                position: absolute">

      <MsgBox04/>
    </div>
  </div>
</template>
<script lang="ts">

import {defineComponent,onMounted,ref} from "vue";
import Navigation from "@/components/Navigation.vue";
import MsgBox01 from "@/components/MsgBox01.vue";
import MsgBox02 from "@/components/MsgBox02.vue";
import MsgBox03 from "@/components/MsgBox03.vue";
import MsgBox04 from "@/components/MsgBox04.vue";
export default defineComponent({
  name:'CyberMessage',
  setup(){

    const status={
      block01: false,
      block02: false,
      block04: false
    };
    const expand01=()=>{
      if(status.block01){
        const line = document.getElementById("msgbox01-line")!;
        line.style.animation="contract 2s";
        line.style.animationFillMode="forwards"
        const frame=document.getElementById("msgbox01-frame")!;
        frame.style.animation="contract 4s";
      }else{
        const line = document.getElementById("msgbox01-line")!;
        line.style.animation="move 3s";
        line.style.animationFillMode="forwards"
        const frame=document.getElementById("msgbox01-frame")!;
        frame.style.animation="show 4s infinite";
      }
      status.block01=!status.block01;
    };
    const expand02=()=>{
      if(status.block02){
        const line2 = document.getElementById("msgbox02-line")!;
        line2.style.animation="contract 2s";
        line2.style.animationFillMode="forwards"
        const frame2=document.getElementById("msgbox02-frame")!;
        frame2.style.animation="contract 2s";
      }else{
        const line2 = document.getElementById("msgbox02-line")!;
        line2.style.animation="move 2s";
        line2.style.animationFillMode="forwards"
        const frame2=document.getElementById("msgbox02-frame")!;
        frame2.style.animation="show 4s infinite";
      }
      status.block02=!status.block02;
    };
    const errorbox=ref(false);
    const expand03=()=>{
      errorbox.value=!errorbox.value;
    };



    const expand04=()=>{
      if(status.block04){
        const line4 = document.getElementById("msgbox04-line")!;
        line4.style.animation="contract 2s";
        line4.style.animationFillMode="forwards"
        const frame4=document.getElementById("msgbox04-frame")!;
        frame4.style.animation="contract 2s";
      }else{
        const line4 = document.getElementById("msgbox04-line")!;
        line4.style.animation="down 2s";
        line4.style.animationFillMode="forwards"
        const frame4=document.getElementById("msgbox04-frame")!;
        frame4.style.animation="move 4s";
        frame4.style.animationFillMode="forwards"
      }
      status.block04=!status.block04;
    };


    onMounted(()=>{
      expand01();
      expand02();
      expand04();
    });

    return{
      expand01,
      expand02,
      expand03,
      expand04,
      errorbox,
    }
  },
  components:{
    Navigation,
    MsgBox01,
    MsgBox02,
    MsgBox03,
    MsgBox04
  }

})
</script>


<style scoped>

/*圆圈扩散动画*/
.wave{
  transform-box: fill-box;
  transform-origin: center;
  transform:  scale(0.5);
  animation: spread 4s infinite;
}
@keyframes spread {
  0%{
    opacity: 1;
    transform: scale(0.5);

  }
  100%{
    opacity: 0.3;
    transform: scale(1.5);
  }

}

#module42:hover{
  opacity: 1;
}
#module46:hover{
  opacity: 0.5;
}
#module47:hover{
  opacity: 0.5;
}
#module51:hover{
  transform-box: fill-box;
  transform-origin: center;
  transform: scale(3);
  opacity: 0.5;
}
</style>