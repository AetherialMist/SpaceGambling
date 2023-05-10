import React from 'react';
import { createRoot } from 'react-dom/client';

function App() {
	return <span>test</span>
}
const domNode = document.getElementById('react');
const root = createRoot(domNode as HTMLElement);
root.render(<App />);