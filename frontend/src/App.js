import React from 'react';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Main from './pages/Main';
import Payments from './pages/Payments';

function App() {
  return (
    <Router>
        <Routes>
          <Route path="/" element={<Main />} />
          <Route path="/payments" element={<Payments />} />
      </Routes>
    </Router>
  )
}

export default App;
