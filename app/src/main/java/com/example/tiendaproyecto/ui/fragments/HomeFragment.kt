package com.example.tiendaproyecto.ui.fragments

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.preference.Preference
import androidx.preference.PreferenceManager
import com.bumptech.glide.Glide
import com.example.tiendaproyecto.R
import com.example.tiendaproyecto.databinding.FragmentHomeBinding
import com.example.tiendaproyecto.ui.home.HomeViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.common.io.Files.map
import org.osmdroid.views.MapView
import org.osmdroid.config.Configuration.*
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.views.overlay.Marker
import org.osmdroid.util.GeoPoint


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var map: MapView;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        getInstance().load(requireContext(), PreferenceManager.getDefaultSharedPreferences(requireContext()))
        return binding.root
    }
    override fun onStart() {
        super.onStart()

        /*homeViewModel.loadStoreInfo()
        homeViewModel.info.observe(viewLifecycleOwner, Observer { store ->
            binding.homeTitle.text = store.name
            binding.homeAddress.text = store.address
            binding.homeDescription.text = store.description
            Glide.with(binding.root).load(store.image).into(binding.homeImage)
*/
            if(ContextCompat.checkSelfPermission(requireContext(),
                    Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(requireContext(),
                    Manifest.permission.ACCESS_NETWORK_STATE) == PackageManager.PERMISSION_GRANTED) {
                binding.mapView.visibility = View.VISIBLE
                binding.mapView.setTileSource(TileSourceFactory.MAPNIK)
                val mapController = binding.mapView.controller
                mapController.setZoom(18.0)
                val startPoint = GeoPoint( 4.574189555090957, -74.10766360559296)
                mapController.setCenter(startPoint)

                val marker = Marker(binding.mapView)
                marker.position = startPoint
                marker.setAnchor(
                    Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM
                )
                marker.title = "Nosotros"
                binding.mapView.overlays.add(marker)
            }

            /*val mapFragment = childFragmentManager.findFragmentById(R.id.home_map) as SupportMapFragment
            lifecycleScope.launchWhenStarted {
                val googleMap = mapFragment.awaitMap()
                addMarker(googleMap, store)
                googleMap.awaitMapLoad()

                val bounds = LatLngBounds.builder()
                    .include(LatLng(store.lat!!, store.lng!!))
                    .build()
                googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 20))

            }*/

        }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    }
    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment= childFragmentManager.findFragmentById(R.id.mapView) as SupportMapFragment
        mapFragment.getMapAsync(this)
        map= binding.mapView
        map.setTileSource(TitleSourceFactory.MAPNIK);
    }*/


