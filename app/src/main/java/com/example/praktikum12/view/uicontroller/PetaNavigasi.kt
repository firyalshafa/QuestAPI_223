package com.example.praktikum12.view.uicontroller

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.praktikum12.view.route.DestinasiDetail
import com.example.praktikum12.view.route.DestinasiEntry
import com.example.praktikum12.view.route.DestinasiHome
import com.example.praktikum12.view.route.DestinasiEdit // PASTIKAN IMPORT INI ADA

@Composable
fun DataSiswaApp(navController: NavHostController = rememberNavController(), modifier: Modifier = Modifier){
    HostNavigasi(navController = navController)
}

@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = modifier
    ){
        // Halaman Home
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                navigateToItemUpdate = { id ->
                    navController.navigate("${DestinasiDetail.route}/$id")
                }
            )
        }

        // Halaman Tambah Siswa
        composable(DestinasiEntry.route){
            EntrySiswaScreen(navigateBack = {
                navController.navigate(DestinasiHome.route) {
                    popUpTo(DestinasiHome.route) { inclusive = true }
                }
            })
        }

        // Halaman Detail Siswa
        composable(
            route = DestinasiDetail.routeWithArgs,
            arguments = listOf(navArgument(DestinasiDetail.itemIdArg) {
                type = NavType.IntType
            })
        ){
            DetailSiswaScreen(
                navigateToEditItem = { id ->
                    navController.navigate("${DestinasiEdit.route}/$id") // PERBAIKAN: Jangan ada enter di sini
                },
                navigateBack = { navController.navigate(DestinasiHome.route) }
            )
        }

        // Halaman Edit Siswa
        composable(
            route = DestinasiEdit.routeWithArgs,
            arguments = listOf(navArgument(DestinasiEdit.itemIdArg) {
                type = NavType.IntType
            })
        ){
            EditSiswaScreen(
                navigateBack = { navController.navigate(DestinasiHome.route) },
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}