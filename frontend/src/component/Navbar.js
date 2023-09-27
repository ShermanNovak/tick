import { Link } from 'react-router-dom'

export const Navbar = () => {
  return (
    <nav className="bg-black w-full sticky top-0 z-50">
      <div className="flex flex-wrap items-center justify-between mx-auto py-4 px-8">
        <button className="font-lemon text-main-yellow text-xl">
        <Link to="/">TICK</Link>
        </button>
        <input
          placeholder="Search Event"
          className="bg-black placeholder-main-yellow text-main-yellow rounded p-1 border-solid border-main-yellow text-sm"
        />
        <button className="bg-main-yellow text-black px-3 py-1 rounded-xl font-inter text-sm font-semibold">
          <Link to="/login">Login/Signup</Link>
        </button>
      </div>
    </nav>
  );
};
