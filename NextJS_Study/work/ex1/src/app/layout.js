import { Inter } from "next/font/google";
import "./globals.css";
import Apple from "./pages/apple/page";

const inter = Inter({ subsets: ["latin"] });

export const metadata = {
  title: "Create Next App",
  description: "Generated by create next app",
};

export default function RootLayout({ children }) {
  return (
    <html lang="en">
      <body className={inter.className}>
        <Apple/>
        <div style={{margin: "0 auto", width: "800px", textAlign: "center"}}>
        {children}
        </div>
        </body>
    </html>
  );
}
