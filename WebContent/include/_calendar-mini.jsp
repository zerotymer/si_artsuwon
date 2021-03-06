<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/assets/style/calendar.css" type="text/css" />

<!-- Calender Mini -->
<div class="calendar-mini">
  <!-- CALENDAR -->
  <div class="frame">
    <!-- calendar HEADER -->
    <div class="calendar-header">
      <div class="btnDiv">
        <button class="curBtn" onclick="setCurDate(-1);"><img src="/assets/icon/arrow-left.png" /></button>
      </div>
      <div class="dateDiv">
        <sapn class="calendar-date" id="miniCalendar-title">오류</sapn>
      </div>
      <div class="btnDiv">
        <button class="curBtn" onclick="setCurDate(1);"><img src="/assets/icon/arrow-right.png" /></button>
      </div>
    </div>
    <!-- calendar CONTENTS -->
    <table class="caldendar-table">
      <thead>
        <tr>
          <th>일</th>
          <th>월</th>
          <th>화</th>
          <th>수</th>
          <th>목</th>
          <th>금</th>
          <th>토</th>
        </tr>
      </thead>
      <tbody id="miniCalendar-tbody">
        <tr>
          <td></td>
          <td>1</td>
          <td>2</td>
          <td>3</td>
          <td class="citizen">4</td>
          <td>5</td>
          <td>6</td>
        </tr>
        <tr>
          <td>7</td>
          <td>8</td>
          <td>9</td>
          <td>10</td>
          <td class="citizen">11</td>
          <td>12</td>
          <td>13</td>
        </tr>
        <tr>
          <td>14</td>
          <td class="citizen">15</td>
          <td>16</td>
          <td class="education">17</td>
          <td>18</td>
          <td>19</td>
          <td class="education">20</td>
        </tr>
        <tr>
          <td>21</td>
          <td class="citizen">22</td>
          <td>23</td>
          <td>24</td>
          <td>25</td>
          <td>26</td>
          <td class="regular">27</td>
        </tr>
        <tr>
          <td>29</td>
          <td>30</td>
          <td>31</td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
        </tr>
      </tbody>
    </table>
  </div>
  <div class="caption">
    <!-- caption -->
    <div class="regular">
      <span>정기</span>
    </div>
    <div class="citizen">
      <span>시민</span>
    </div>
    <div class="tour">
      <span>순회</span>
    </div>
    <div class="outside">
      <span>외부</span>
    </div>
    <div class="education">
      <span>교육</span>
    </div>
  </div>
</div>

<script src="/assets/js/calendar-mini.js"></script>
