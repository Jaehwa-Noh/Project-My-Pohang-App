//
//  CategoryView.swift
//  My Pohang App
//
//  Created by Jaehwa Noh on 12/22/23.
//

import SwiftUI

struct CategoryView: View {
    private var categoryViewModel = CategoryViewModel()
    
    var body: some View {
        Form {
            Section {
                ForEach(categoryViewModel.categories) {
                    category in
                    NavigationLink {
                        RecommendView(category: categoryViewModel.selectedCategory)
                    } label: {
                        HStack {
                            Image(systemName: category.iconName)
                            Text("\(category.categoryName)")
                        }
                    }
                }
            }
        }
    }
}

#Preview {
    CategoryView()
}
