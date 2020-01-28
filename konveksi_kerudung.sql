-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 28 Jan 2020 pada 15.57
-- Versi server: 10.1.37-MariaDB
-- Versi PHP: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `konveksi_kerudung`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `bahanbaku_kain`
--

CREATE TABLE `bahanbaku_kain` (
  `id_kain` varchar(5) NOT NULL,
  `name` varchar(20) NOT NULL,
  `type` varchar(20) NOT NULL,
  `color` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `bahanbaku_kain`
--

INSERT INTO `bahanbaku_kain` (`id_kain`, `name`, `type`, `color`) VALUES
('1', 'Crepe', 'Wolly Crepe', 'Dusty Tua,Dusty Muda,Milo,Moca,Armi,Mustard,Navi,Hitam,Maron,Abu'),
('2', 'Polyster', 'Polycotton', 'Dusty Tua,Dusty Muda, Milo, Moca, Armi, Mustard, Navi, Hitam, Maron, Abu');

-- --------------------------------------------------------

--
-- Struktur dari tabel `produk`
--

CREATE TABLE `produk` (
  `id_produk` varchar(5) NOT NULL,
  `name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `produk`
--

INSERT INTO `produk` (`id_produk`, `name`) VALUES
('1', 'Kerudung Syari'),
('2', 'Krd Basic'),
('3', 'Krd Pasmina');

-- --------------------------------------------------------

--
-- Struktur dari tabel `produksi`
--

CREATE TABLE `produksi` (
  `id_produksi` int(5) NOT NULL,
  `id_produk` varchar(5) NOT NULL,
  `id_kain` varchar(5) NOT NULL,
  `warna` varchar(11) NOT NULL,
  `qty` int(11) NOT NULL,
  `ukuran` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `produksi`
--

INSERT INTO `produksi` (`id_produksi`, `id_produk`, `id_kain`, `warna`, `qty`, `ukuran`) VALUES
(1, '3', '1', 'Dusty Muda', 70, 50),
(2, '1', '2', ' Navi', 70, 33),
(3, '2', '2', ' Navi', 70, 45),
(4, '2', '1', 'Armi', 60, 55),
(5, '3', '1', 'Armi', 65, 40),
(6, '2', '2', ' Mustard', 55, 40),
(7, '1', '1', 'Milo', 55, 44),
(8, '2', '2', ' Abu', 44, 33),
(9, '3', '2', ' Mustard', 55, 66),
(10, '1', '2', ' Milo', 66, 88),
(11, '2', '2', 'Dusty Tua', 44, 55),
(12, '2', '2', ' Milo', 44, 44),
(13, '3', '1', 'Armi', 40, 55),
(14, '2', '2', ' Navi', 50, 50);

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id_user` varchar(10) NOT NULL,
  `nama_user` varchar(25) NOT NULL,
  `no_telepon` varchar(15) NOT NULL,
  `email` varchar(50) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id_user`, `nama_user`, `no_telepon`, `email`, `username`, `password`) VALUES
('1', 'lukman', '0895357670185', 'admin@gmail.com', 'admin', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `bahanbaku_kain`
--
ALTER TABLE `bahanbaku_kain`
  ADD PRIMARY KEY (`id_kain`);

--
-- Indeks untuk tabel `produk`
--
ALTER TABLE `produk`
  ADD PRIMARY KEY (`id_produk`);

--
-- Indeks untuk tabel `produksi`
--
ALTER TABLE `produksi`
  ADD PRIMARY KEY (`id_produksi`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
