import React from 'react';
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import { Toaster } from 'react-hot-toast';
import { AuthProvider, useAuth } from './context/AuthContext';
import Navbar from './components/Navbar';
import Footer from './components/Footer';
import HomePage from './pages/HomePage';
import LoginPage from './pages/LoginPage';
import RegisterPage from './pages/RegisterPage';
import AttendancePage from './pages/AttendancePage';
import AssignmentPage from './pages/AssignmentPage';
import DashboardPage from './pages/DashboardPage';
import AdminPage from './pages/AdminPage';
import CoursesPage from './pages/CoursesPage';

const ProtectedRoute = ({ children, roles }) => {
  const { user, loading } = useAuth();
  if (loading) return <div className="loading"><div className="spinner"></div>Loading...</div>;
  if (!user) return <Navigate to="/login" />;
  if (roles && !roles.includes(user.role)) return <Navigate to="/" />;
  return children;
};

const Layout = ({ children, noFooter }) => (
  <>
    <Navbar />
    {children}
    {!noFooter && <Footer />}
  </>
);

const AppRoutes = () => {
  const { user } = useAuth();
  return (
    <Routes>
      <Route path="/" element={<Layout><HomePage /></Layout>} />
      <Route path="/login" element={user ? <Navigate to="/" /> : <Layout><LoginPage /></Layout>} />
      <Route path="/register" element={user ? <Navigate to="/" /> : <Layout><RegisterPage /></Layout>} />
      <Route path="/courses" element={<Layout><CoursesPage /></Layout>} />
      <Route path="/about" element={<Layout><div style={{ padding: '120px 40px', maxWidth: 800, margin: '0 auto', textAlign: 'center' }}><h1 style={{ fontSize: '2.5rem', marginBottom: 16 }}>About Veltech University</h1><p style={{ color: 'var(--text-muted)', lineHeight: 2 }}>Founded in 1984, Veltech University has been a beacon of academic excellence and innovation. Our commitment to world-class education, cutting-edge research, and holistic student development makes us a leader in technical education in India.</p></div></Layout>} />
      <Route path="/student" element={
        <ProtectedRoute roles={['STUDENT']}>
          <Layout><DashboardPage /></Layout>
        </ProtectedRoute>
      } />
      <Route path="/faculty" element={
        <ProtectedRoute roles={['FACULTY']}>
          <Layout><DashboardPage /></Layout>
        </ProtectedRoute>
      } />
      <Route path="/attendance" element={
        <ProtectedRoute roles={['FACULTY', 'ADMIN']}>
          <Layout><AttendancePage /></Layout>
        </ProtectedRoute>
      } />
      <Route path="/assignments" element={
        <ProtectedRoute roles={['STUDENT']}>
          <Layout><AssignmentPage /></Layout>
        </ProtectedRoute>
      } />
      <Route path="/admin" element={
        <ProtectedRoute roles={['ADMIN']}>
          <Layout><AdminPage /></Layout>
        </ProtectedRoute>
      } />
      <Route path="*" element={<Navigate to="/" />} />
    </Routes>
  );
};

function App() {
  return (
    <BrowserRouter>
      <AuthProvider>
        <Toaster
          position="top-right"
          toastOptions={{
            style: {
              background: '#142240',
              color: '#fff',
              border: '1px solid rgba(201,168,76,0.2)',
              borderRadius: '10px',
              fontSize: '0.88rem',
            },
            success: { iconTheme: { primary: '#4caf8a', secondary: '#fff' } },
            error: { iconTheme: { primary: '#e85d5d', secondary: '#fff' } },
          }}
        />
        <AppRoutes />
      </AuthProvider>
    </BrowserRouter>
  );
}

export default App;
